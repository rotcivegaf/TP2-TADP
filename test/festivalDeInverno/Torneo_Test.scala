package festivalDeInverno

import org.junit.Before
import org.junit.Test
import org.junit.Assert._

import participantes.Vikingo
import participantes.SistemaVuelo
import participantes.Comestible
import participantes.Arma


class Torneo_Test {
  var torneo: Torneo = null 
  
  var hipo   :Vikingo = null
  var astrid :Vikingo = null
  var patan  :Vikingo = null
  var patapez:Vikingo = null
  
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
    
    hipo = new Vikingo(peso = 100, velocidad = 50, barbarosidad = 150, item = sistemaDeVuelo)
    astrid = new Vikingo(peso = 100, velocidad = 50, barbarosidad = 150, item = hacha)
    patan = new Vikingo(peso = 100, velocidad = 50, barbarosidad = 150, item = maza)
    patapez = new Vikingo(peso = 100, velocidad = 50, barbarosidad = 150, item = comestible)
    
    torneo = new Torneo(List(hipo, astrid, patan, patapez), null, null)
  }
  
  /*@Test def danio_test() = {
    assertEquals(150 + 100, unVikingo.danio, 0.1)
    assertFalse(unVikingo.danio == 0)
  }*/

}