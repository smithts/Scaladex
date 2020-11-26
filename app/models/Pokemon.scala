package models

import play.api.libs.json.{JsArray, JsValue, JsString}

/**
 * Pokemon class
 *
 * Will take in either a string or a JSON object, depending on other choices.
 *
 * Will encapsulate all necessary information needed to display a Pokemon.
 * */
class Pokemon(var name: String, var jsonData: JsValue) {
  // Constants

  //Stats array indexes
  private val HP = 0
  private val ATTACK = 1
  private val DEFENSE = 2
  private val SPECIAL_ATTACK = 3
  private val SPECIAL_DEFENSE = 4
  private val SPEED = 5

  val typeRelations = Array("Normal", "Fire", "Water", "Electric", "Grass", "Ice", "Fighting", "Poison", "Ground", "Flying", "Psychic", "Bug", "Rock", "Ghost", "Dragon", "Dark", "Steel", "Fairy")

  // Class values
  val id = jsonData("id").toString()

  // will parse this from data
  // or maybe not?
  var description = ""

  // will parse this from data
  var types = new Array[String](2)
  parseTypesArray(jsonData("types"))


  // will parse this from data
  var stats = new Array[Stat](6)
  parseStatArray(jsonData("stats"))

  // image url for the pokemon
  val imageURL = "https://img.pokemondb.net/artwork/"+ name.toLowerCase + ".jpg"

  var primaryTypeAdvantages = Array[Double](18)


  // Test method
  def roar(): Unit = {
    print("Roar!")
  }

  /**
   * This method parses out the provided data and builds the array of stats for the given pokemon
   *
   * Results stored in and accessible from "stats" field
   *
   */
  private def parseStatArray(json: JsValue): Unit = {
    stats(HP) = Stat("HP", json(HP)("base_stat").toString.toInt)
    stats(ATTACK) = Stat("Attack", json(ATTACK)("base_stat").toString.toInt)
    stats(DEFENSE) = Stat("Defense", json(DEFENSE)("base_stat").toString.toInt)
    stats(SPECIAL_ATTACK) = Stat("Special Attack", json(SPECIAL_ATTACK)("base_stat").toString.toInt)
    stats(SPECIAL_DEFENSE) = Stat("Special Defense", json(SPECIAL_DEFENSE)("base_stat").toString.toInt)
    stats(SPEED) = Stat("Speed", json(SPEED)("base_stat").toString.toInt)
  }

  def parseTypesArray(json: JsValue): Unit = {
    types(0) = json(0)("type")("name").as[String].capitalize

    if (json.as[JsArray].value.size == 2) {
      types(1)= json(1)("type")("name").as[String].capitalize
    }
  }

  // Specified Getter for HP
  def hp(): Int = {
    stats(HP).basePower
  }

  // Specified Getter for Attack
  def attack(): Int = {
    stats(ATTACK).basePower
  }

  // Specified Getter for Defense
  def defense(): Int = {
    stats(DEFENSE).basePower
  }

  // Specified Getter for Sp. Attack
  def specialAttack(): Int = {
    stats(SPECIAL_ATTACK).basePower
  }

  // Specified Getter for Sp. Defense
  def specialDefense(): Int = {
    stats(SPECIAL_DEFENSE).basePower
  }

  // Specified Getter for Speed
  def speed(): Int = {
    stats(SPEED).basePower
  }

  def getDamageMultiplier(other: Pokemon): Double = {
    var multiplier = 1.0

    var otherType1 = other.types(0)
    multiplier *= primaryTypeAdvantages(typeRelations.indexOf(otherType1))

    if (other.types(1) != null) {
      multiplier *= primaryTypeAdvantages(typeRelations.indexOf(other.types(1)))
    }

    return multiplier
  }
}
