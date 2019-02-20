package controllers

import javax.inject.{Inject, Singleton}
import play.api.mvc.{AbstractController, ControllerComponents}

@Singleton()
class CustomerController @Inject()(cc: ControllerComponents)
    extends AbstractController(cc) {}
