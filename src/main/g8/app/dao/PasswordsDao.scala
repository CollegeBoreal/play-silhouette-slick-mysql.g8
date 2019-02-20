package dao

import javax.inject.{Inject, Singleton}
import models.Password
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile
import slick.lifted

import scala.concurrent.{ExecutionContext, Future}

trait PasswordComponent { self: HasDatabaseConfigProvider[JdbcProfile] =>
  import profile.api._
  import slick.lifted.ProvenShape

  class PasswordTable(tag: Tag) extends Table[Password](tag, "PASSWORDS") {

    // scalastyle:off magic.number
    def providerKey: Rep[String] = column[String]("providerKey", O.Length(45, varying = true), O.PrimaryKey)
    def hasher: Rep[String] = column[String]("hasher")
    def password: Rep[String] = column[String]("password")
    def salt: Rep[String] = column[String]("salt")
    // scalastyle:on magic.number

    // scalastyle:off method.name
    override def * : ProvenShape[Password] =
      (providerKey ?, hasher, password, salt) <> (Password.tupled, Password.unapply)
    // scalastyle:on method.name

  }

}

@Singleton
class PasswordDao @Inject()(
    protected val dbConfigProvider: DatabaseConfigProvider)(
    implicit executionContext: ExecutionContext)
    extends PasswordComponent
    with HasDatabaseConfigProvider[JdbcProfile] {

  import profile.api._

  val passwords = lifted.TableQuery[PasswordTable]

  def getAll(): Future[Seq[Password]] = db.run(passwords.result)

}
