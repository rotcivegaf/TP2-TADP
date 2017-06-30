package participantes

trait Participante {
  require(velocidad >= 0, "La velocidad debe ser positiva")
  
  val velocidad:Float
  val barbarosidad: Int
  val item: Item
  var nivHambre: Int = 0
  
  def cargaMax: Double
  def danio: Float
  def darHambre(cant: Int)
  def puedeParticipar(cant:Int): Boolean
  def usarItemPostposta() = {}
  def quitarHambre(cant: Int) = {
    nivHambre -= cant
    if(nivHambre <= 0) nivHambre = 0 
  }
}