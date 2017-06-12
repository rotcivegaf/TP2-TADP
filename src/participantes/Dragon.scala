package participantes

trait Dragon {
  val peso: Float
  val velBase: Float
  val danio: Float
  
  val cargaMax:Double = peso*0.2
  val barbarosidadMinima: Float = 0
  val itemNecesario: Item
  
  require(peso >= 0, "El peso debe ser positivo")
  require(velBase >= 0, "la velocidad base debe ser positiva")
  require(danio >= 0, "El danio debe ser positivo")
  
  def velVuelo: Float =  velBase - peso
  def monturaExitosa(unVikingo: Vikingo):Boolean = (unVikingo.peso <= cargaMax) && (unVikingo.barbarosidad >= barbarosidadMinima) && 
    (unVikingo.item == itemNecesario || itemNecesario == null)
}
