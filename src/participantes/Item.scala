package participantes

class Item(val danio: Float = 0) {
  require(danio >= 0, "El danio debe ser positivo")
  
}