package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import models._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class ScaladexController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {
  val rest = new PokemonRESTRetriever()
  val manager = new BattleManager()

}
