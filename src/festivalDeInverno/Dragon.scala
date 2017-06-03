package festivalDeInverno

abstract class Dragon {
  val peso: Float
  val velBase: Float = 60
  val danio: Float
  
  def velVuelo(): Float =  velBase - peso
}