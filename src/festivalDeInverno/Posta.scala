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
    
  def participar(participante: Participante) = {
    getPuntuacion(participante)
  }

  def mejorDragon(vikingo: Vikingo, dragones: List[Dragon]): Option[Dragon] = {
    dragones
      .filter(_.monturaExitosa(vikingo))
      .sortBy(getPuntuacionJinete(vikingo, _))
      .headOption
  }
  
  def getPuntuacionJinete(vikingo: Vikingo, dragon: Dragon){
    getPuntuacion(vikingo.montar(dragon))
  }
}
