package models

class BattleManager {
  var allPreviousBattles: Set[Battle] = Set()

  def createBattle(pkmn1: Pokemon, pkmn2: Pokemon): Battle = {
    if (pkmn1 == null || pkmn2 == null) {
      //Pokemon must not be null, return null to front end
      return null
    }

    //Checks cache for similar battle that already occurred
    var battle = checkBattleCache(pkmn1,pkmn2)

    //If similar battle not in cache, instantiate new battle using provided Pokemon
    if (battle == null) {
      battle = new Battle(pkmn1, pkmn2)
    } else {
      // if it was in the cache, just return it
      return battle
    }

    //Execute the battle
    processBattle(battle)

    if (battle.winner != null) {
      battle.completed = true;

      //Store previous Battle in the cache in case we want to use that.
      allPreviousBattles += battle;

      return battle
    } else {
      //Something went wrong. Battle did not determine a winner
      return null
    }

  }

  // Carries out a battle, and stores it in the battle cache
  def processBattle(battle: Battle): Unit = {
    val p1 = battle.pkmn1
    val p2 = battle.pkmn2

    val p1Advantage = p1.getDamageMultiplier(p2)
    val p2Advantage = p2.getDamageMultiplier(p1)

    //Keeping this equal for both Pokemon now.
    val attackPower = 50;


    val p1Damage: Double = ((((22) * p1.attack() * attackPower / p2.defense()) / 50) + 2) * 1.5 * p1Advantage //* r / 100
    val p1SpecialDamage: Double = ((((22) * p1.specialAttack() * attackPower / p2.specialDefense()) / 50) + 2) * 1.5 * p1Advantage //* r / 100
    val p2Damage: Double = (((22 * p2.attack() * attackPower / p1.defense()) / 50) + 2) * p2Advantage //* r / 100
    val p2SpecialDamage: Double = ((((22) * p2.specialAttack() * attackPower / p1.specialDefense()) / 50) + 2) * p2Advantage //* r / 100

    if ((p1Damage + p1SpecialDamage) > (p2Damage + p2SpecialDamage)) {
      battle.winner = battle.pkmn1
    } else if ((p1Damage + p1SpecialDamage) < (p2Damage + p2SpecialDamage)) {
      battle.winner = battle.pkmn2
    } else {
      // Damage equal, default to faster Pokemon
      // If speed equal, Pkmn1 wins.
      if (p1.speed() >= p2.speed()) {
        battle.winner = battle.pkmn1
      } else {
        battle.winner = battle.pkmn2
      }
    }
  }

  def checkBattleCache(pkmn1: Pokemon, pkmn2: Pokemon): Battle = {
    allPreviousBattles.foreach(battle =>
      if (battle.combatants.contains(pkmn1.name) && battle.combatants.contains(pkmn2.name)) {
        return battle
      }
    )
    return null
  }
}
