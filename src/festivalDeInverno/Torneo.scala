package festivalDeInverno

import participantes.Dragon
import participantes.Participante
import participantes.Jinete
import participantes.Desmontado

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
  
  def montarMejorDragon(desmontado: Desmontado, posta: Posta): Participante = {
    val dragon = posta.mejorDragon(desmontado, dragones)
    dragon match {
      case None => return desmontado
      case Some(d) => {
        if (posta.getPuntuacion(desmontado) > posta.getPuntuacion(desmontado.montar(d))){
          return desmontado
        }else{
          dragones.filter(_ == d)
          return desmontado.montar(d)
        }
      }
    }
  }
  
  def montar(participante: Participante, posta: Posta): Participante = {
    participante match {       
      case _: Desmontado => return montarMejorDragon(participante.asInstanceOf[Desmontado], posta)
      case _ => return participante
    }
  }
  
  def desmontar(participante: Participante): Participante = {
    participante match {
      case j: Jinete =>{
        j.dragon :: dragones
        return j.desmontado
      }
      case _ => return participante
    }
  }
}