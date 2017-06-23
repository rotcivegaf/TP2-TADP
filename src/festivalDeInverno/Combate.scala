package festivalDeInverno

import participantes.Participante
import participantes.Arma

case class Combate(barbarosidadMin:Int = 0, arma:Arma = null) extends Posta{
  val cantHambre = 10;
  
  def cumpleCriterio(participante: Participante):Boolean = participante.barbarosidad >= barbarosidadMin &&
    (participante.item == arma || arma == null)
  
  def getPuntuacion(participante: Participante): Double = participante.danio
}