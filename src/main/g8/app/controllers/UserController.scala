package controllers

import java.sql.Timestamp
import java.text.SimpleDateFormat

import dao.UserDao
import javax.inject.{Inject, Singleton}
import models.User
import play.api.libs.json._
import play.api.mvc.{
  AbstractController,
  Action,
  AnyContent,
  ControllerComponents
}

import scala.concurrent.ExecutionContext

@Singleton()
class UserController @Inject()(
    cc: ControllerComponents,
    userDao: UserDao)(implicit ec: ExecutionContext)
    extends AbstractController(cc) {

  implicit val fmt: Format[User] = Json.format[User]

  def getAll: Action[AnyContent] = Action.async { implicit request =>
    for { user <- userDao.getAll } yield Ok(Json.toJson(user))
  }
}
