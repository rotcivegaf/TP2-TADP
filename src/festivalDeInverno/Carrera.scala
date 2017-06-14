package festivalDeInverno

import participantes.Participante

case class Carrera(km: Int, monturaNecesaria:Boolean = false) extends Posta{
  val cantHambre: Int = km
  
  def cumpleCriterio(participante: Participante):Boolean = !monturaNecesaria /*|| TODO que sea jinete*/
  
  def getPuntuacion(participante: Participante): Double = participante.velocidad
} 