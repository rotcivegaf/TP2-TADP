package festivalDeInverno

import participantes.Participante
import participantes.Vikingo
import participantes.Jinete
import participantes.Dragon

trait Posta {
  val cantHambre: Int
  
  def cumpleCriterio(participante: Participante):Boolean
  
  def puedeParticipar(participante: Participante):Boolean = 
    cumpleCriterio(participante) && participante.puedeParticipar(cantHambre)
  
  def getPuntuacion(participante: Participante): Double
  
  def efecto(participante: Participante): Participante = {
    participante.darHambre(cantHambre)
    return participante
  }
    
  def mejorDragon(vikingo: Vikingo, dragones: List[Dragon]): Option[Dragon] = {
    dragones
      .filter(_.monturaExitosa(vikingo))
      .sortWith(getPuntuacionJinete(vikingo, _, _))
      .headOption
  }
  
  def participar(participante1: Participante, participante2: Participante): Boolean = {
    getPuntuacion(participante1)>getPuntuacion(participante2)
  }

  
  def getPuntuacionJinete(vikingo: Vikingo, dragon1: Dragon, dragon2: Dragon): Boolean = {
    getPuntuacion(vikingo.montar(dragon1))>getPuntuacion(vikingo.montar(dragon2))
  }
}
