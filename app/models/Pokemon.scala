package models

import play.api.libs.json.JsValue

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

  // Class values
  val id = jsonData("id").toString()

  // will parse this from data
  // or maybe not?
  var description = ""

  // will parse this from data
  var types = new Array[Type](2)

  // will parse this from data
  var stats = new Array[Stat](6)
  parseStatArray(jsonData("stats"))

  // image url for the pokemon
  val imageURL = "https://img.pokemondb.net/artwork/"+ name.toLowerCase + ".jpg"

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
    stats(HP) = Stat("HP", json(0)("base_stat").toString.toInt)
    stats(ATTACK) = Stat("Attack", json(1)("base_stat").toString.toInt)
    stats(DEFENSE) = Stat("Defense", json(2)("base_stat").toString.toInt)
    stats(SPECIAL_ATTACK) = Stat("Special Attack", json(3)("base_stat").toString.toInt)
    stats(SPECIAL_DEFENSE) = Stat("Special Defense", json(4)("base_stat").toString.toInt)
    stats(SPEED) = Stat("Speed", json(5)("base_stat").toString.toInt)
  }

  // Specified Getter for HP
  def getHP(): Int = {
    stats(HP).basePower
  }

  // Specified Getter for Attack
  def getAttack(): Int = {
    stats(ATTACK).basePower
  }

  // Specified Getter for Defense
  def getDefense(): Int = {
    stats(DEFENSE).basePower
  }

  // Specified Getter for Sp. Attack
  def getSpecialAttack(): Int = {
    stats(SPECIAL_ATTACK).basePower
  }

  // Specified Getter for Sp. Defense
  def getSpecialDefense(): Int = {
    stats(SPECIAL_DEFENSE).basePower
  }

  // Specified Getter for Speed
  def getSpeed(): Int = {
    stats(SPEED).basePower
  }
  
}
