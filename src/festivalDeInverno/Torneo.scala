package festivalDeInverno

import participantes.Dragon
import participantes.Participante
import participantes.Jinete
import participantes.Vikingo

case class Torneo(participantes: List[Participante], dragones: List[Dragon], postas: List[Posta]) {
  
  def realizarTorneo(): Option[Participante] = {
    postas.foldLeft (None :Option[Participante]) {(semilla, posta) => {
        var participantesEnPie = participarEnUna(posta)
        participantesEnPie match {
          case List() => None
          case h::Nil => return Option(h)
          case d => Some(d.head)
        }
      }
    }
  }
  
  def participarEnUna(posta:Posta): List[Participante] = {
    participantes
      .map(montar(_, posta))  
      .filter(posta.puedeParticipar)
      .sortWith(posta.participar)
      .map(posta.efecto)
      .map(desmontar)
  }
  
  def montarMejorDragon(vikingo: Vikingo, posta: Posta): Participante = {
    val dragon = posta.mejorDragon(vikingo, dragones)
    dragon match {
      case None => return vikingo
      case Some(d) => {
        if (posta.getPuntuacion(vikingo) > posta.getPuntuacion(vikingo.montar(d))){
          return vikingo
        }else{
          dragones.filter(_ == d)
          return vikingo.montar(d)
        }
      }
    }
  }
  
  def montar(participante: Participante, posta: Posta): Participante = {
    participante match {       
      case _: Vikingo => return montarMejorDragon(participante.asInstanceOf[Vikingo], posta)
      case _ => return participante
    }
  }
  
  def desmontar(participante: Participante): Participante = {
    participante match {
      case j: Jinete =>{
        j.dragon :: dragones
        return j.vikingo
      }
      case _ => return participante
    }
  }
}