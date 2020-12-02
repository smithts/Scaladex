package controllers

import javax.inject._
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
    Ok(views.html.search("A Scala PokeDex"))
  }

  def search_results(name: String) = Action { implicit request: Request[AnyContent] =>
    var poke = rest.getPokemon(name)
    if (poke == null) {
      Redirect("../search")
    } else {
      Ok(views.html.pokedex3("A Scala Pokedex")(poke))
    }

  }

  def battle() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.battle())
  }

  def battle_results(name1:String, name2: String) = Action { implicit request: Request[AnyContent] =>
    var p1 = rest.getPokemon(name1)
    var p2 = rest.getPokemon(name2)

    if(p1 == null || p2 == null) {
      Redirect("../battle")
    } else {
      val battle = manager.createBattle(p1, p2)

      Ok(views.html.battle_results(battle.winner))
    }
  }

  def allBattles() = Action { implicit request: Request[AnyContent] =>
    var result = "Previous Battles:\n"
    manager.allPreviousBattles.foreach(battle => result += battle.toString + "\n")

    Ok(result)
  }
}
