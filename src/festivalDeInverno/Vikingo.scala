package festivalDeInverno

class Vikingo(val peso: Float, val velocidad: Float, val barbarosidad: Int, var nivHambre: Int, val item: Item) {
  
    def cargaMax: Double = {(peso*0.5) + (barbarosidad*2)}
  
    def danio:Float = {barbarosidad + item.danio}
    
}