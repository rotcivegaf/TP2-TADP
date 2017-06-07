package participantes

case class Gronckle(peso: Float, override val cargaMax:Double, itemNecesario:Item = null) extends Dragon{
  val danio: Float =  peso*5 
  val velBase:Float = 60/2
  
  override def monturaExitosa(unVikingo: Vikingo):Boolean = (unVikingo.peso <= cargaMax)
  
}