package participantes

im

import participantes.Itemport festivalDeInverno.Item

case class Vikingo(peso: Float, velocidad: Float, barbarosidad: Int, var nivHambre: Int, item: Item) {

  require(peso >= 0, "El peso debe ser positivo")
  require(velocidad >= 0, "La velocidad debe ser positiva")
  require(nivHambre >= 0 && nivHambre <=100, "El nivel de hambre debe ser de 0% a 100%")
  
  def cargaMax: Double = {(peso*0.5) + (barbarosidad*2)}
  
  def danio:Float = {barbarosidad + item.danio}
    
}