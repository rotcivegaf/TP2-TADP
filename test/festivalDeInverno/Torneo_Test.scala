package festivalDeInverno

import org.junit.Before
import org.junit.Test
import org.junit.Assert._

import participantes.Vikingo
import participantes.Jinete
import participantes.Patapez


import participantes.SistemaVuelo
import participantes.Comestible
import participantes.Arma

import participantes.NedderMortifero
import participantes.FuriaNocturna
import participantes.Dragon

class Torneo_Test {
  var torneoImposible: Torneo = null
  var torneo: Torneo = null
  var torneo2: Torneo = null
  
  var carrera:Carrera = null
  var pesca  :Pesca   = null
  var combate:Combate = null
  var unNedder:NedderMortifero = null
  var unNedder2:NedderMortifero = null
  var unFuria:FuriaNocturna = null
  
  var hipo   :Vikingo = null
  var astrid :Vikingo = null
  var patan  :Vikingo = null
  var patapez:Patapez = null
  
  var jinete:Jinete = null
  
  var sistemaDeVuelo: SistemaVuelo = null
  var comestible    : Comestible = null
  var hacha         : Arma = null
  var maza          : Arma = null 
  
  @Before
  def setup() = {
    comestible     = new Comestible(25)
    sistemaDeVuelo = new SistemaVuelo()
    hacha = new Arma(30)
    maza  = new Arma(100)
    
    hipo = new Vikingo(peso = 100, velocidad = 50, barbarosidad = 1, item = sistemaDeVuelo)
    astrid = new Vikingo(peso = 100, velocidad = 50, barbarosidad = 150, item = hacha)
    patan = new Vikingo(peso = 200, velocidad = 50, barbarosidad = 150, item = maza)
    patapez = new Patapez(peso = 100, velocidad = 50, barbarosidad = 150, item = comestible)
    
    unNedder = new NedderMortifero(peso = 500, velBase = 300, sistemaDeVuelo)
    unNedder2 = new NedderMortifero(peso = 700, velBase = 129)
    unFuria = new FuriaNocturna(peso = 1700, velBase = 130, danio = 100, itemNecesario = maza)
 
    jinete = hipo.montar(unNedder)
    //jinete2 = hipo.montar(unNedder2)
    
    carrera = new Carrera(km = 90, monturaNecesaria = true)
    pesca   = new Pesca(pesoMinimo = 235)
    combate = new Combate(barbarosidadMin = 70, arma = hacha)
    
    
    torneoImposible = new Torneo(participantes = List(hipo, astrid, patan, patapez),
                        dragones = List(unFuria, unNedder, unNedder2), 
                        postas = List(carrera, pesca, combate,combate,combate,combate,carrera, pesca, combate,combate,combate,combate,carrera, pesca, combate,combate,combate,combate))
        
    torneo = new Torneo(participantes = List(hipo, astrid, patan, patapez),
                        dragones = List(unFuria, unNedder, unNedder2), 
                        postas = List(carrera, pesca, combate))
    torneo2 = new Torneo(participantes = List(hipo, astrid, patan, patapez),
                        dragones = List(unFuria, unNedder, unNedder2), 
                        postas = List(carrera))
  }
  
  @Test def montar_test() = {
    assertEquals(patan, torneo.montar(patan, carrera))
    assertEquals(jinete, torneo.montar(hipo, combate))
  }
  
  @Test def participarEnUna_test() = {
    assertEquals(List(), torneo.participarEnUna(carrera))
    assertEquals(List(patan, astrid, patapez), torneo.participarEnUna(pesca))
    assertEquals(List(astrid), torneo.participarEnUna(combate))
  }
  
  @Test def realizarTorneoImposible_test() = {
    assertEquals(None, torneoImposible.realizarTorneo())
  }
  @Test def realizarTorneo_test() = {
    assertEquals(Some(astrid), torneo.realizarTorneo())
  }
  @Test def realizarTorneo2_test() = {
    assertEquals(Some(astrid), torneo.realizarTorneo())
  }
}
