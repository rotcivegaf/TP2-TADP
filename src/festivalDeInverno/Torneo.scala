package festivalDeInverno

import participantes.Dragon
import participantes.Participante
import participantes.Jinete
import participantes.Vikingo

case class Torneo(participantes: List[Participante], var dragones: List[Dragon], postas: List[Posta]) {
    /*
  def realizarTorneo(): Option[Vikingo] = {
    postas.foldLeft (null) {
      (semilla, posta) => {

        if(!vikingosEnPie.isEmpty)
          vikingosEnPie.head
      }
    }
  }*/
  
  def participarEnUna(posta:Posta){
    participantes
      .filter(posta.puedeParticipar)
      .map(montar(_, posta))
      .sortBy(posta.participar)
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