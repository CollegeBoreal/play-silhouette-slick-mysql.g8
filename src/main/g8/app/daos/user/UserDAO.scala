package daos.user

import javax.inject.{Inject, Singleton}
import models.User
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile
import slick.lifted

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class UserDAO @Inject()(protected val dbConfigProvider: DatabaseConfigProvider)(
    implicit ec: ExecutionContext)
    extends UserDTO
    with HasDatabaseConfigProvider[JdbcProfile] {

  import profile.api._

  val users = lifted.TableQuery[UserTable]

  def getAll: Future[Seq[User]] = db.run(users.result)

}
