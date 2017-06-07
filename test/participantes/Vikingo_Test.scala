package participantes

import org.junit.Before
import org.junit.Test
import org.junit.Assert._

class Vikingo_Test {
  var unVikingo:Vikingo = null
  var unItem:Item = null

  @Before
  def setup() = {
    unItem = new Item(danio = 100)
    unVikingo = new Vikingo(peso = 100, velocidad = 50, barbarosidad = 150, item = unItem, nivHambre = 0)
  }

  @Test def danio_test() = {
    assertEquals(150 + 100, unVikingo.danio, 0.1)
    assertFalse(unVikingo.danio == 0)
  }
  
  @Test def cargaMax_test() = {
    assertEquals((100*0.5) + (150*2), unVikingo.cargaMax, 0.1)
  }
} 