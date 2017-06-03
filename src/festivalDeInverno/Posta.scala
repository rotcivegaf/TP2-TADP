package festivalDeInverno

import participantes.Vikingo

abstract class Posta {
  val incHambre: Int
  
  def participar(participantes: List[Vikingo])
}