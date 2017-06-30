package participantes

trait Desmontado extends Participante{
  require(peso >= 0, "El peso debe ser positivo")
  require(nivHambre >= 0 && nivHambre <=100, "El nivel de hambre debe ser de 0% a 100%")
  
  val peso: Float

  def cargaMax: Double = (peso*0.5) + (barbarosidad*2)
    
  def danio:Float = barbarosidad + item.danio
   
  def montar(dragon: Dragon): Jinete = new Jinete(this, dragon)
}