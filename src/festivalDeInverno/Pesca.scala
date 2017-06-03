package festivalDeInverno

import participantes.Vikingo

class Pesca extends Posta {
  val incHambre: Int = 5
  
  def participar(participantes: List[Vikingo]) = {participantes.map(_.nivHambre += incHambre)}
  
}