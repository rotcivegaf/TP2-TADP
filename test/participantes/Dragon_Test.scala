package participantes

import org.junit.Before
import org.junit.Test
import org.junit.Assert._

class Dragon_Test {
  var unNedder:NedderMortifero = null
  var unFuria:FuriaNocturna = null
  var unGronckle:Gronckle = null
  
  @Before
  def setup() = {
    unNedder = new NedderMortifero(500, 60)
    unFuria = new FuriaNocturna(30, 60,50)
    unGronckle = new Gronckle(500, 300)
    
  }
  
  @Test def furia_dragon_test() = {
    assertEquals( (60-30)*3, unFuria.velVuelo, 0.1)
  }
}