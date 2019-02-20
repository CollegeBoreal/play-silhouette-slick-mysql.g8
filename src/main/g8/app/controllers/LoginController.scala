package controllers

import dao.LoginDao
import javax.inject.{Inject, Singleton}
import models.Login
import play.api.libs.json.{Format, Json}
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}

@Singleton()
class LoginController @Inject()(cc: ControllerComponents, loginDao: LoginDao)(
    implicit ec: ExecutionContext)
    extends AbstractController(cc) {

  implicit val fmt: Format[Login] = Json.format[Login]

  def getAll: Action[AnyContent] = Action.async { implicit request =>
    for { login <- loginDao.getAll } yield Ok(Json.toJson(login))
  }
}
