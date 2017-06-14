package festivalDeInverno

import participantes.Participante

trait Posta {
  val cantHambre: Int
  
  def cumpleCriterio(participante: Participante):Boolean
  
  def puedeParticipar(participante: Participante):Boolean = {
    cumpleCriterio(participante) && participante.puedeParticipar(cantHambre)
   }
  
  def getPuntuacion(participante: Participante): Double
    
  def participar(participante: Participante) = {
    participante.darHambre(cantHambre)
    getPuntuacion(participante)
  }
}
