package participantes

import org.junit.Before
import org.junit.Test
import org.junit.Assert._

class Jinete_Test {
  var unVikingo:Vikingo = null
  var unItem:Item = null
  
  var unNedder:NedderMortifero = null
  var unFuria:FuriaNocturna = null
  var unGronckle:Gronckle = null
  
  var unJinete:Jinete = null

  @Before
  def setup() = {
    unItem = new Arma(danio = 100)
    unVikingo = new Vikingo(peso = 100, velocidad = 50, barbarosidad = 150, item = unItem, nivHambre = 0)
    
    unNedder = new NedderMortifero(500, 60)
    unFuria = new FuriaNocturna(30, 60,50)
    unGronckle = new Gronckle(500, 300)
    
    //unJinete = 
  }

  @Test def danio_test() = {
    assertEquals(150 + 100, unVikingo.danio, 0.1)
    assertFalse(unVikingo.danio == 0)
  }
  
  @Test def cargaMax_test() = {
    assertEquals((100*0.5) + (150*2), unVikingo.cargaMax, 0.1)
  }
  
  @Test def darHambre_test() = {
    unVikingo.darHambre(50)
    
    assertEquals(50, unVikingo.nivHambre)
  }
  
  @Test def puedeParticipar_test() = {
    assertTrue(unVikingo.puedeParticipar(50))
    assertFalse(unVikingo.puedeParticipar(120))
  }
} 