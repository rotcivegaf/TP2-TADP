package festivalDeInverno

import participantes.Vikingo

abstract class Posta {
  require(incHambre >= 0 && incHambre <=100, "El incremento de hambre debe ser de 0% a 100%")
  
  val incHambre: Int
  
  def participar(participantes: List[Vikingo])
}