package participantes

case class Comestible(cantHambre: Int) extends Item {
  def efectoPostPosta(participante: Participante) = participante.darHambre(-cantHambre)
    
  override def usar(participante: Participante) = participante.quitarHambre(cantHambre)
}