package participantes

case class Jinete(vikingo: Vikingo, dragon:Dragon) extends Participante {
  val velocidad:Float = dragon.velVuelo - vikingo.peso 
  val barbarosidad: Int = vikingo.barbarosidad
  val item: Item = vikingo.item
  
  def cargaMax: Double = vikingo.peso - dragon.cargaMax
  
  def danio:Float = vikingo.danio + dragon.danio
    
  def darHambre(cant: Int) = vikingo.nivHambre + 5
  
  def puedeParticipar(cant:Int): Boolean = vikingo.nivHambre + 5 < 100
    
}