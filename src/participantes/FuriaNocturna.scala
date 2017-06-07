package participantes

case class FuriaNocturna(val peso: Float, val velBase: Float = 60, val danio: Float, itemNecesario:Item = null) extends Dragon{  
 
  override def velVuelo: Float =  super.velVuelo*3
 
}