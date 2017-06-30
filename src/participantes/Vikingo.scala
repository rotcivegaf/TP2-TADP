package participantes

case class Vikingo(peso: Float, barbarosidad: Int, item: Item = null, velocidad: Float) extends Desmontado {

  def darHambre(cant: Int) = nivHambre += cant
  
  def puedeParticipar(cant:Int): Boolean = nivHambre + cant < 100
}
