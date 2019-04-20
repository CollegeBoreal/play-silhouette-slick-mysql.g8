package controllers

import daos.login.LoginDAO
import javax.inject.{Inject, Singleton}
import models.Login
import play.api.libs.json.{Format, Json}
import play.api.mvc._

import scala.concurrent.ExecutionContext

@Singleton()
class LoginController @Inject()(cc: ControllerComponents, loginDao: LoginDAO)(
    implicit ec: ExecutionContext)
    extends AbstractController(cc) {

  implicit val fmt: Format[Login] = Json.format[Login]

  def getAll: Action[AnyContent] = Action.async { implicit request =>
    for { login <- loginDao.getAll } yield Ok(Json.toJson(login))
  }
}
