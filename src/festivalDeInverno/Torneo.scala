package festivalDeInverno

import participantes.Dragon
import participantes.Participante

case class Torneo(participantes: List[Participante], dragones: List[Dragon], postas: List[Posta]) {
  
  def competirEnUna(posta: Posta, participantes: List[Participante]): List[Participante] = {
    participantes
      .filter(posta.puedeParticipar(_))
      .sortBy(posta.participar(_))      
  }
}