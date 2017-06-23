package festivalDeInverno

import org.junit.Before
import org.junit.Test
import org.junit.Assert._

import participantes.Vikingo
import participantes.Jinete


import participantes.SistemaVuelo
import participantes.Comestible
import participantes.Arma

import participantes.NedderMortifero


class Posta_Test {
  var carrera:Carrera = null
  var pesca  :Pesca   = null
  var combate:Combate = null
  var unNedder:NedderMortifero = null
  
  var hipo   :Vikingo = null
  var astrid :Vikingo = null
  var patan  :Vikingo = null
  var patapez:Vikingo = null
  
  var jinete:Jinete = null
  
  var sistemaDeVuelo: SistemaVuelo = null
  var comestible    : Comestible = null
  var hacha         : Arma = null
  var maza          : Arma = null 
  
  @Before
  def setup() = {
    comestible     = new Comestible()
    sistemaDeVuelo = new SistemaVuelo()
    hacha = new Arma(30)
    maza  = new Arma(100)
    
    hipo    = new Vikingo(peso = 120, velocidad = 20, barbarosidad = 85 , item = sistemaDeVuelo)
    astrid  = new Vikingo(peso = 150, velocidad = 10, barbarosidad = 70 , item = hacha)
    patan   = new Vikingo(peso = 300, velocidad = 40, barbarosidad = 90 , item = maza)
    patapez = new Vikingo(peso = 80 , velocidad = 35, barbarosidad = 100, item = comestible)
    
    unNedder = new NedderMortifero(peso = 700, velBase = 130)
    jinete = hipo.montar(unNedder)
    
    carrera = new Carrera(km = 100, monturaNecesaria = false)
    pesca   = new Pesca(pesoMinimo = 0)
    combate = new Combate(barbarosidadMin = 0, arma = null)
    
    
  }
  
  @Test def getPuntuacion_test() = {
    assertEquals(20, carrera.getPuntuacion(hipo), 0.1)
    assertEquals(230, pesca.getPuntuacion(hipo), 0.1)
    assertEquals(85, combate.getPuntuacion(hipo), 0.1)
    
    assertEquals(130-700-120, carrera.getPuntuacion(jinete), 0.1)
    assertEquals(120-700*0.2, pesca.getPuntuacion(jinete), 0.1)
    assertEquals(235, combate.getPuntuacion(jinete), 0.1)
  }
  

}