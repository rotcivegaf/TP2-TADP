package participantes

case class Patapez(peso: Float, barbarosidad: Int, item: Item = new Comestible(50), velocidad: Float) extends Desmontado{
  def darHambre(cant: Int) = nivHambre += cant*2
  
  def puedeParticipar(cant:Int): Boolean = nivHambre + cant*2 < 50
}