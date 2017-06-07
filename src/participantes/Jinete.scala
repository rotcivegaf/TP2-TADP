package participantes

class Jinete(peso: Float, barbarosidad: Int, item: Item, nivHambre: Int, velocidad: Float, dragon:Dragon)
  extends Vikingo(peso, barbarosidad, item, nivHambre, velocidad = dragon.velVuelo - peso){
    
  override def cargaMax: Double = peso - dragon.cargaMax  
  
  override def danio:Float = super.danio + dragon.danio
  
  
  //Los jinetes sólo incrementan 5% de hambre independientemente de la posta a jugar
}