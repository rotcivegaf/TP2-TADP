package festivalDeInverno

class Pesca(val participantes: List[Vikingo]) extends Posta {
  val incHambre: Int = 5
  
  def participar = {participantes.map(_.nivHambre += incHambre)}
  
}