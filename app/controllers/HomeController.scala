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
class HomeController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {
  val rest = new PokemonRESTRetriever()
  val manager = new BattleManager()

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.pokedex1("Test"))
  }

  def pokedex3(name: String) = Action { implicit request: Request[AnyContent] =>
    var poke = rest.getPokemon(name)
    Ok(views.html.pokedex3("Test")(poke))
  }

  def battle1() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.battle1())
  }

  def battle3() = Action { implicit request: Request[AnyContent] =>
    var winner = rest.getPokemon("Mewtwo")
    Ok(views.html.battle3(winner))
  }
}
