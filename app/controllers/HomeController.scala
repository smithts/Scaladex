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
    Ok(views.html.pokedex1("A Scala Pokedex"))
  }

  def pokedex3(name: String) = Action { implicit request: Request[AnyContent] =>
    var poke = rest.getPokemon(name)
    Ok(views.html.pokedex3("A Scala Pokedex")(poke))
  }

  def battle1() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.battle1())
  }

  def battle3(name1:String, name2: String) = Action { implicit request: Request[AnyContent] =>
    var p1 = rest.getPokemon(name1)
    var p2 = rest.getPokemon(name2)

    val battle = manager.createBattle(p1, p2)

    Ok(views.html.battle3(battle.winner))
  }

  def allBattles() = Action { implicit request: Request[AnyContent] =>
    var result = "Previous Battles:\n"
    manager.allPreviousBattles.foreach(battle => result += battle.toString + "\n")

    Ok(result)
  }
}
