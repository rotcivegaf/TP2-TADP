package participantes

class Vikingo(val peso: Float, val velocidad: Float, val barbarosidad: Int, val item: Item,  var nivHambre: Int = 0) {

  require(peso >= 0, "El peso debe ser positivo")
  require(velocidad >= 0, "La velocidad debe ser positiva")
  require(nivHambre >= 0 && nivHambre <=100, "El nivel de hambre debe ser de 0% a 100%")
  
  def cargaMax: Double =(peso*0.5) + (barbarosidad*2)
  
  def danio:Float = barbarosidad + item.danio
  
  def montar(unDragon:Dragon):Any = {
    if(unDragon.monturaExitosa(this))
      new Jinete(unDragon)
    else
      this
  }
}