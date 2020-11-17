package models

/**
 * Pokemon class
 *
 * Will take in either a string or a JSON object, depending on other choices.
 *
 * Will encapsulate all necessary information needed to display a Pokemon.
 * */
class Pokemon(var data: String) {
  // Constants

  //Stats array indexes
  private val HP = 0
  private val ATTACK = 1
  private val DEFENSE = 2
  private val SPECIAL_ATTACK = 3
  private val SPECIAL_DEFENSE = 4
  private val SPEED = 5

  // Class values

  // will parse this from data
  var name = ""

  // will parse this from data
  var description = ""

  // will parse this from data
  var types = new Array[Type](2)

  // will parse this from data
  var stats = new Array[Stat](6)
  parseStatArray()


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
  private def parseStatArray(): Unit = {
    //These are obviously fake values. Will need to parse them from the JSON
    stats(HP) = Stat("HP", 100)
    stats(ATTACK) = Stat("Attack", 101)
    stats(DEFENSE) = Stat("Defense", 102)
    stats(SPECIAL_ATTACK) = Stat("Special Attack", 103)
    stats(SPECIAL_DEFENSE) = Stat("Special Defense", 104)
    stats(SPEED) = Stat("Speed", 105)
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
