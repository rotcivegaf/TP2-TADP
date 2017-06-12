package participantes

trait Participante {
  
  def cargaMax: Double
  def danio: Float
  def incHambre(cant: Int)
  def puedeParticipar(cant:Int): Boolean
}