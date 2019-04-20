package controllers

import daos.password.PasswordDAO
import javax.inject.{Inject, Singleton}
import models.Password
import play.api.libs.json.{Format, Json}
import play.api.mvc._

import scala.concurrent.ExecutionContext

@Singleton()
class PasswordController @Inject()(
    cc: ControllerComponents,
    passwordDao: PasswordDAO)(implicit ec: ExecutionContext)
    extends AbstractController(cc) {

  implicit val fmt: Format[Password] = Json.format[Password]

  def getAll: Action[AnyContent] = Action.async { implicit request =>
    for { password <- passwordDao.getAll } yield Ok(Json.toJson(password))
  }
}
