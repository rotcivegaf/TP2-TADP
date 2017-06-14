package festivalDeInverno

import participantes.Participante

case class Pesca(pesoMinimo:Float = 0) extends Posta{
  val cantHambre: Int = 5
  
  def cumpleCriterio(participante: Participante):Boolean = participante.cargaMax > pesoMinimo
  
  def getPuntuacion(participante: Participante): Double = participante.cargaMax
}