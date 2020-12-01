package models

class Battle(var pkmn1: Pokemon, var pkmn2: Pokemon) {
  var winner: Pokemon = null;
  var loser: Pokemon = null;

  //used for simple comparison of battles.
  val combatants: Set[String] = Set(pkmn1.name, pkmn2.name)

  var completed: Boolean = false

  //
  override def toString: String = {
    winner.name + " defeats " + loser.name
  }

}
