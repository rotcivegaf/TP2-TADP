package participantes

case class NedderMortifero(peso: Float, velBase: Float = 60, itemNecesario:Item = null) extends Dragon{
  
  val danio: Float = 150
  
  override def monturaExitosa(desmontado: Desmontado):Boolean = super.monturaExitosa(desmontado) && 
    (desmontado.danio <= danio) && (itemNecesario == null || itemNecesario == desmontado.item)
}