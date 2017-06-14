package participantes

case class Vikingo(peso: Float, barbarosidad: Int, item: Item = null, var nivHambre: Int = 0, velocidad: Float) extends Participante {
  require(peso >= 0, "El peso debe ser positivo")
  require(velocidad >= 0, "La velocidad debe ser positiva")
  require(nivHambre >= 0 && nivHambre <=100, "El nivel de hambre debe ser de 0% a 100%")

  
  def cargaMax: Double = (peso*0.5) + (barbarosidad*2)
    
  def danio:Float = barbarosidad + item.danio
  
  def darHambre(cant: Int) = nivHambre += cant
  
  def puedeParticipar(cant:Int): Boolean = nivHambre + cant < 100
  
  def montar(dragon: Dragon): Participante  = 
    if (dragon.monturaExitosa(this))
      new Jinete(this, dragon)
    else
      this
}
