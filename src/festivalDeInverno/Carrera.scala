package festivalDeInverno

import participantes.Vikingo

class Carrera(km: Int) extends Posta{
  val hambreInc: Int = km
  
  override def participar(participantes: List[Vikingo]) = {
    participantes.map(_.incHambre(hambreInc))
    darHambre(participantes)
  }

} 