package models

class TypeUtils() {

  //Hardcoded type advantages
  val typeRelations:Map[String,Array[Double]] = Map(
    "Normal" -> Array(1,1,1,1,1,1,1,1,1,1,1,1,0.5,0,1,1,0.5,1),
    "Fire" -> Array(1,0.5,0.5,1,2,2,1,1,1,1,1,2,0.5,1,0.5,1,2,1),
    "Water" -> Array(1,2,0.5,1,0.5,1,1,1,2,1,1,1,2,1,0.5,1,1,1),
    "Electric" -> Array(1,1,2,0.5,0.5,1,1,1,0,2,1,1,1,1,0.5,1,1,1),
    "Grass" -> Array(1,0.5,2,1,0.5,1,1,0.5,2,0.5,1,0.5,2,1,0.5,1,0.5,1),
    "Ice" -> Array(1,0.5,0.5,1,2,0.5,1,1,2,2,1,1,1,1,2,1,0.5,1),
    "Fighting" -> Array(2,1,1,1,1,2,1,0.5,1,0.5,0.5,0.5,2,0,1,2,2,0.5),
    "Poison" -> Array(1,1,1,1,2,1,1,0.5,0.5,1,1,1,0.5,0.5,1,1,0,2),
    "Ground" -> Array(1,2,1,2,0.5,1,1,2,1,0,1,0.5,2,1,1,1,2,1),
    "Flying" -> Array(1,1,1,0.5,2,1,2,1,1,1,1,2,0.5,1,1,1,0.5,1),
    "Psychic" -> Array(1,1,1,1,1,1,2,2,1,1,0.5,1,1,1,1,0,0.5,1),
    "Bug" -> Array(1,0.5,1,1,2,1,0.5,0.5,1,0.5,2,1,1,0.5,1,2,0.5,0.5),
    "Rock" -> Array(1,2,1,1,1,2,0.5,1,0.5,2,1,2,1,1,1,1,0.5,1),
    "Ghost" -> Array(0,1,1,1,1,1,1,1,1,1,2,1,1,2,1,0.5,1,1),
    "Dragon" -> Array(1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,0.5,0),
    "Dark" -> Array(1,1,1,1,1,1,0.5,1,1,1,2,1,1,2,1,0.5,1,0.5),
    "Steel" -> Array(1,0.5,0.5,0.5,1,2,1,1,1,1,1,1,2,1,1,1,0.5,2),
    "Fairy" -> Array(1,0.5,1,1,1,1,2,0.5,1,1,1,1,1,1,2,2,0.5,1)
  )

  def getTypeRelations(pokemonType: String): Array[Double] = {
    if (typeRelations.contains(pokemonType)) {
      return typeRelations.get(pokemonType).get
    } else {
      null
    }
  }



}
