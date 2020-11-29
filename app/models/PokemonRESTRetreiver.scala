package models

import java.io.FileNotFoundException

import scala.io.Source
import play.api.libs.json._

/**
 * Gets Pokemon information from PokeAPI Url
 *
 * Creates Pokemon objects from procured information
 *
 * */
class PokemonRESTRetriever {

  // Simple cache mechanism
  private var pokeMap:Map[String, Pokemon] = Map()

  // Serves the Type advantage/disadvantage info to the Pokemon class
  private var utils = new TypeUtils()

  @throws(classOf[java.io.IOException])
  def getPokemon(name: String): Pokemon = {
      val pokemonName = name.toLowerCase()

      // checks the cache map for the pokemon
      if (pokeMap.contains(pokemonName)) {
        //map.get returns an Option[Pokemon]
        var opt = pokeMap.get(pokemonName)

        return opt.get
      }

      val url = "https://pokeapi.co/api/v2/pokemon/" + pokemonName

      try {
        var response = Source.fromURL(url).mkString

        if (response.equals("Not Found")) {
          //pokemon does not exist in PokeAPI
          return null
        } else {

          val json: JsValue = Json.parse(response)

          //Create pokemon object
          val pokemon = new Pokemon(pokemonName.capitalize, json)

          //Using types, get the primary type advantage and assign to pokemon.primaryTypeAdvantages field
          pokemon.primaryTypeAdvantages = utils.getTypeRelations(pokemon.types(0))

          //add pokemon to the cache map
          pokeMap += (name -> pokemon)

          return pokemon

        }

      } catch {
        case e: FileNotFoundException => return null
      }


    }
}
