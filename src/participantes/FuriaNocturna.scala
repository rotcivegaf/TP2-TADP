package participantes

case class FuriaNocturna(peso: Float) extends Dragon{
  
	def velVuelo:Float = super.velVuelo()*3
}