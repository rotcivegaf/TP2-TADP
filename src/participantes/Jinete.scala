package participantes

case class Jinete(vikingo: Vikingo, dragon:Dragon) extends Participante {
 
  def cargaMax: Double = vikingo.peso - dragon.cargaMax
  
  def danio:Float = vikingo.danio + dragon.danio
    
  def incHambre(cant: Int) = vikingo.nivHambre + 5
  
  def puedeParticipar(cant:Int): Boolean = vikingo.nivHambre + 5 < 100
}