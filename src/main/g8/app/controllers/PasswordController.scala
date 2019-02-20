package controllers

import dao.PasswordsDao
import javax.inject.{Inject, Singleton}
import models.Password
import play.api.libs.json.{Format, Json}
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}

@Singleton()
class PasswordsController @Inject()(
    cc: ControllerComponents,
    passwordDao: PasswordDao)(implicit ec: ExecutionContext)
    extends AbstractController(cc) {

  implicit val fmt: Format[Password] = Json.format[Password]

  def getAll: Action[AnyContent] = Action.async { implicit request =>
    for { password <- passwordDao.getAll } yield Ok(Json.toJson(password))
  }
}
