package participantes

case class NedderMortifero(peso: Float, velBase: Float = 60, itemNecesario:Item = null) extends Dragon{
  
  val danio: Float = 150
  
  override def monturaExitosa(unVikingo: Vikingo):Boolean = super.monturaExitosa(unVikingo) && (unVikingo.danio <= danio)
}