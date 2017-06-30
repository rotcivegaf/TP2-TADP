package participantes

case class Arma(override val danio:Float) extends Item {    
  require(danio >= 0, "El danio debe ser positivo")
}