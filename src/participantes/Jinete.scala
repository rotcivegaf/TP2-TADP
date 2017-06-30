package participantes

case class Jinete(desmontado: Desmontado, dragon:Dragon) extends Participante {
  val velocidad:Float = dragon.velVuelo - desmontado.peso 
  val barbarosidad: Int = desmontado.barbarosidad
  val item: Item = desmontado.item
  
  def cargaMax: Double = desmontado.peso - dragon.cargaMax
  
  def danio:Float = desmontado.danio + dragon.danio
    
  def darHambre(cant: Int) = desmontado.nivHambre + 5
  
  def puedeParticipar(cant:Int): Boolean = desmontado.nivHambre + 5 < 100
    
}