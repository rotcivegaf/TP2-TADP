package participantes

case class Gronckle(peso: Float, override val cargaMax:Double, itemNecesario:Item = null) extends Dragon{
  val danio: Float =  peso*5 
  lazy val velBase:Float = velBase/2
  
  override def monturaExitosa(desmontado: Desmontado):Boolean = (desmontado.peso <= cargaMax)
  
}