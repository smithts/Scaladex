package models

/**
* Stores the variety(hp,attack,defense, etc.) and basePower of stats
*
*
* */
case class Stat(var variety: String, var basePower: Int) {

  //
  override def toString: String = {
    variety + ": " + basePower
  }
}
