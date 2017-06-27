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
import participantes.FuriaNocturna
import participantes.Dragon


class Posta_Test {
  var carrera:Carrera = null
  var pesca  :Pesca   = null
  var combate:Combate = null
  var unNedder:NedderMortifero = null
  var unNedder2:NedderMortifero = null
  var unFuria:FuriaNocturna = null
  
  var hipo   :Vikingo = null
  var astrid :Vikingo = null
  var patan  :Vikingo = null
  var patapez:Vikingo = null
  
  var jinete:Jinete = null
  var jinete2:Jinete = null
  
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
    unNedder2 = new NedderMortifero(peso = 700, velBase = 129)
    unFuria = new FuriaNocturna(peso = 1700, velBase = 130, danio = 100, itemNecesario = maza)
 
    jinete = hipo.montar(unNedder)
    //jinete2 = hipo.montar(unNedder2)
    
    carrera = new Carrera(km = 100, monturaNecesaria = true)
    pesca   = new Pesca(pesoMinimo = 235)
    combate = new Combate(barbarosidadMin = 70, arma = hacha)
  }
  
  @Test def getPuntuacion_test() = {
    assertEquals(20, carrera.getPuntuacion(hipo), 0.1)
    assertEquals(230, pesca.getPuntuacion(hipo), 0.1)
    assertEquals(85, combate.getPuntuacion(hipo), 0.1)
    
    assertEquals(130-700-120, carrera.getPuntuacion(jinete), 0.1)
    assertEquals(120-700*0.2, pesca.getPuntuacion(jinete), 0.1)
    assertEquals(235, combate.getPuntuacion(jinete), 0.1)
  }
  
  @Test def puedeParticipar_test() = {
    assertFalse(carrera.puedeParticipar(hipo))
    assertTrue(carrera.puedeParticipar(jinete))
    assertFalse(pesca.puedeParticipar(hipo))//cargaMax = 230
    assertTrue(pesca.puedeParticipar(patapez))//cargaMax = 240
    assertTrue(combate.puedeParticipar(astrid))
    assertFalse(combate.puedeParticipar(hipo))    
  }
  
  @Test def mejorDragon_test() = {
    assertEquals(None, carrera.mejorDragon(hipo, List[Dragon](unFuria)))
    assertEquals(Some(unNedder2), carrera.mejorDragon(hipo, List[Dragon](unFuria, unNedder2)))
    assertEquals(Some(unNedder), carrera.mejorDragon(hipo, List[Dragon](unFuria, unNedder2, unNedder)))
  }
}