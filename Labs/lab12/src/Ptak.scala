var nr=0
abstract class Ptak {
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

class ListyPtakow {
  var listLatanie:List[Ptak with latanie]  = List[Ptak with latanie]()
  var listNurkowanie:List[Ptak with nurkowanie]  = List[Ptak with nurkowanie]()
  var listPlywanie:List[Ptak with plywanie]  = List[Ptak with plywanie] ()
  var listBieganie:List[Ptak with bieganie]  = List[Ptak with bieganie]()

  def wyswietlLatanie():Unit={
    println()
    println("Latajace")
    for (ptak<- listLatanie) ptak.msgLatanie()
  }
  def wyswietlNurkowanie():Unit={
    println()
    println("Nurkujace")
    for (ptak<- listNurkowanie) ptak.msgNurkowanie()
  }
  def wyswietlPlywanie():Unit={
    println()
    println("Plywajace")
    for (ptak<- listPlywanie) ptak.msgPlywanie()
  }
  def wyswietlBieganie():Unit={
    println()
    println("Biegajace")
    for (ptak<- listBieganie) ptak.msgBieganie()
  }
  def dodajPtakaDoGrup(ptak:Ptak):Unit={
    if ptak.isInstanceOf[latanie] then
      listLatanie= listLatanie:::List(ptak.asInstanceOf[latanie])
    if ptak.isInstanceOf[nurkowanie] then
      listNurkowanie= listNurkowanie:::List(ptak.asInstanceOf[nurkowanie])
    if ptak.isInstanceOf[plywanie] then
      listPlywanie= listPlywanie:::List(ptak.asInstanceOf[plywanie])
    if ptak.isInstanceOf[bieganie] then
      listBieganie= listBieganie:::List(ptak.asInstanceOf[bieganie])
  }
  def wyswietlWszystko():Unit =
    wyswietlLatanie()
    wyswietlNurkowanie()
    wyswietlPlywanie()
    wyswietlBieganie()
}

def testPtak():Unit =
  val listyPtakow = new ListyPtakow
  listyPtakow.dodajPtakaDoGrup(new Pingwin)
  listyPtakow.dodajPtakaDoGrup(new Golab)
  listyPtakow.dodajPtakaDoGrup(new Strus)
  listyPtakow.dodajPtakaDoGrup(new Sokol)
  listyPtakow.dodajPtakaDoGrup(new Kura)
  listyPtakow.dodajPtakaDoGrup(new Pingwin)
  listyPtakow.dodajPtakaDoGrup(new Golab)
  listyPtakow.dodajPtakaDoGrup(new Strus)

  listyPtakow.wyswietlWszystko()



