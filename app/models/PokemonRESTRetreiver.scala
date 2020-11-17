package models

import scala.io.Source
import play.api.libs.json._

/**
 * Gets Pokemon information from PokeAPI Url
 *
 * Creates Pokemon objects from procured information
 *
 * */
class PokemonRESTRetriever {
  // This will do all the parsing necessary
  val jsonParser = new PokemonJSONParser()

  // Simple cache mechanism
  var pokeMap:Map[String, Pokemon] = Map()


  @throws(classOf[java.io.IOException])
  //def getPokemon(name: String): Option[Pokemon] = {
  def getPokemon(name: String): String = {
      val pokemonName = name.toLowerCase()

      // checks the cache map for the pokemon
      if (pokeMap.contains(pokemonName)) {
        //return pokeMap.get(pokemonName)
      }

      val url = "https://pokeapi.co/api/v2/pokemon/" + pokemonName

      try {
        var response = Source.fromURL(url).mkString

        if (response.equals("Not Found")) {
          //pokemon does not exist in PokeAPI
          return null
        } else {
          val json: JsValue = Json.parse(response)

          // Incomplete, but this now returns a JsValue with
          // all of the stats
          return json("stats").toString()
        }

      }
      // not really sure how exceptions work, ironically
      //catch () {

      //}




      //placeholder
      //null

    }
  //}


}
