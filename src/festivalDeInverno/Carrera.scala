package festivalDeInverno

import participantes.Participante
import participantes.Jinete

case class Carrera(km: Int, monturaNecesaria:Boolean = false) extends Posta{
  val cantHambre: Int = km
  
  def cumpleCriterio(participante: Participante):Boolean ={
    participante match {    
      case _: Jinete => return true
      case _ => return false
    }
  }
  
  def getPuntuacion(participante: Participante): Double = participante.velocidad
} 