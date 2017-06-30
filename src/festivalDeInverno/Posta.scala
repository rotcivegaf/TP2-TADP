package festivalDeInverno

import participantes.Participante
import participantes.Desmontado
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
    participante.usarItemPostposta()
    return participante
  }
    
  def mejorDragon(desmontado: Desmontado, dragones: List[Dragon]): Option[Dragon] = {
    dragones
      .filter(_.monturaExitosa(desmontado))
      .sortWith(getPuntuacionJinete(desmontado, _, _))
      .headOption
  }
  
  def participar(participante1: Participante, participante2: Participante): Boolean = {
    getPuntuacion(participante1)>getPuntuacion(participante2)
  }

  
  def getPuntuacionJinete(desmontado: Desmontado, dragon1: Dragon, dragon2: Dragon): Boolean = {
    getPuntuacion(desmontado.montar(dragon1))>getPuntuacion(desmontado.montar(dragon2))
  }
}
