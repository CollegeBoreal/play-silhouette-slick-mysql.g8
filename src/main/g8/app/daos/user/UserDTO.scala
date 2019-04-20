package daos.user

import java.sql.Timestamp
import java.time.LocalDateTime

import javax.inject.{Inject, Singleton}
import models.User
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile
import slick.lifted

import scala.concurrent.{ExecutionContext, Future}

abstract class UserDTO { self: HasDatabaseConfigProvider[JdbcProfile] =>

  import profile.api._
  import slick.lifted.ProvenShape

  class UserTable(tag: Tag) extends Table[User](tag, "USERS") {

    import UserTable._

    // scalastyle:off magic.number
    def user: Rep[Long] = column[Long]("user", O.PrimaryKey, O.AutoInc)

    def number: Rep[String] =
      column[String]("number", O.Length(45, varying = true))

    def providerKey: Rep[String] =
      column[String]("providerKey", O.Length(45, varying = true))

    def active: Rep[Boolean] = column[Boolean]("active")

    def created: Rep[LocalDateTime] = column[LocalDateTime]("created")

    // scalastyle:off method.name
    override def * : ProvenShape[User] =
      (number, providerKey, active, created, user).mapTo[User]
    // scalastyle:on method.name

  }

  object UserTable {
    implicit val localDateTimeColumnType: BaseColumnType[LocalDateTime] =
      MappedColumnType.base[LocalDateTime, Timestamp](
        Timestamp.valueOf,
        _.toLocalDateTime
      )
  }

}