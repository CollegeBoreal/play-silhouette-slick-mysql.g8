package dao

import javax.inject.{Inject, Singleton}
import models.Customer
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile
import slick.lifted
import slick.lifted.TableQuery

import scala.concurrent.{ExecutionContext, Future}

trait CustomersComponent { self: HasDatabaseConfigProvider[JdbcProfile] =>
  import profile.api._
  import slick.lifted.ProvenShape

  class CustomersTable(tag: Tag) extends Table[Customer](tag, "customers") {

    // scalastyle:off magic.number
    def customer: Rep[Int] = column[Int]("customer", O.PrimaryKey, O.AutoInc)

    def name: Rep[String] = column[String]("name", O.Length(45, varying = true))

    def phone: Rep[String] =
      column[String]("phone", O.Length(45, varying = true))
    // scalastyle:on magic.number

    // scalastyle:off method.name
    override def * : ProvenShape[Customer] =
      (customer ?, name, phone) <> (Customer.tupled, Customer.unapply)
    // scalastyle:on method.name

  }

}

@Singleton
class CustomersDao @Inject()(
    protected val dbConfigProvider: DatabaseConfigProvider)(
    implicit executionContext: ExecutionContext)
    extends CustomersComponent
    with HasDatabaseConfigProvider[JdbcProfile] {

  import profile.api._

  val customers = lifted.TableQuery[CustomersTable]

  def getAll(): Future[Seq[Customer]] = db.run(customers.result)

}
