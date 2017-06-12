package festivalDeInverno

import participantes.Vikingo

abstract class Posta {
  val hambreInc: Int
  
  
  
  def darHambre(participantes: List[Vikingo]) = {participantes.map(_.incHambre(hambreInc))}

  def participar(participantes: List[Vikingo]) = {
  		
  		darHambre(participantes)
  }
}
