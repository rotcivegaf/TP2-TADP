package participantes

trait Participante {
  val velocidad:Float
  val barbarosidad: Int
  val item: Item
  
  def cargaMax: Double
  def danio: Float
  def darHambre(cant: Int)
  def puedeParticipar(cant:Int): Boolean
  
}