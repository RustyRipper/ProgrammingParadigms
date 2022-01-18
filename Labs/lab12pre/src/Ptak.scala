var nr=0
class Ptak {
  val nrEwidencyjny:Int =
    nr=nr+1
    nr
  println("Pochodze od dinozaurow!!!")
}
trait latanie extends Ptak:
  def msgLatanie():Unit =
    println("Ptak nr "+nrEwidencyjny +" - "+ getClass.getSimpleName())
    var value:String=""
    if getClass.getSimpleName == "Golab" then
      value = "Dobrze"
    else if getClass.getSimpleName == "Sokol" then
      value = "Znakomicie"
    else if getClass.getSimpleName == "Kura" then
      value = "Słabo"
    println(value+" latam")

trait nurkowanie extends Ptak:
  def msgNurkowanie():Unit =
    println("Ptak nr "+nrEwidencyjny +" - "+ getClass.getSimpleName())
    println("Nurkuje")

trait plywanie extends Ptak:
  def msgPlywanie():Unit =
    println("Ptak nr "+nrEwidencyjny +" - "+ getClass.getSimpleName())
    println("Plywam")

trait bieganie extends Ptak:
  def msgBieganie():Unit =
    println("Ptak nr "+nrEwidencyjny +" - "+ getClass.getSimpleName())
    var value:String=""
    if getClass.getSimpleName == "Golab" then
      value = "Słabo"
    else if getClass.getSimpleName == "Strus" then
      value = "Swietnie"
    else if getClass.getSimpleName == "Kura" then
      value = "Dobrze"
    println(value+" biegam")

class Sokol extends Ptak with latanie
class Pingwin extends Ptak with nurkowanie with plywanie
class Golab extends Ptak with bieganie with plywanie with latanie
class Kura extends Ptak with latanie with bieganie
class Strus extends Ptak with bieganie

def testPtak():Unit =
  val p1= new Pingwin
  val p2= new Golab
  val p3= new Strus
  val p4= new Sokol
  val p5= new Kura
  val p6= new Pingwin
  val p7= new Golab
  val p8= new Strus
  val listLatanie:List[Ptak with latanie]  = List(p2, p4,p5,p7)
  val listNurkowanie:List[Ptak with nurkowanie]  = List(p1,p6)
  val listPlywanie:List[Ptak with plywanie]  = List(p1,p2,p6,p7)
  val listBieganie:List[Ptak with bieganie]  = List(p2,p3,p5,p7,p8)

  for (ptak<- listLatanie) ptak.msgLatanie()
  for (ptak<- listNurkowanie) ptak.msgNurkowanie()
  for (ptak<- listPlywanie) ptak.msgPlywanie()
  for (ptak<- listBieganie) ptak.msgBieganie()