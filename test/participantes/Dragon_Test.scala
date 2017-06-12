package participantes

import org.junit.Before
import org.junit.Test
import org.junit.Assert._

class Dragon_Test {
  var unNedder:NedderMortifero = null
  var unFuria:FuriaNocturna = null
  var unGronckle:Gronckle = null
  
  var unItem:Item = null
  var unVikingo:Vikingo = null
  

  @Before
  def setup() = {
    unItem = new Item(100)
    //unVikingo = new Vikingo(100, 50, 150, item = unItem)
    unNedder = new NedderMortifero(500, 60, unItem)
    unFuria = new FuriaNocturna(30, 60,50, unItem)
    unGronckle = new Gronckle(500, 300, unItem)
    
  }
  
  @Test def furia_dragon_test() = {
    assertEquals( (60-30)*3, unFuria.velVuelo, 0.1)
  }
  
  @Test def dragon_test() = {
    assertTrue(unFuria.monturaExitosa(unVikingo))
  }
}