
object Obora {
  var nr:Int=0
}
class Obora( val wlasciciel:String, val liczbaBoksow:Int) {
  val nrObory:Int =
    nr=nr+1
    nr
  var listaZwierzat:List[Zwierzak] = List()

  def zakwateruj(zwierzak: Zwierzak):Boolean =
    if listaZwierzat.length < liczbaBoksow then
      listaZwierzat=listaZwierzat:::List(zwierzak)
      println("kwateruje "+zwierzak.toString)
      true
    else
      println("brak miejsc")
      false

  def wykwateruj(imieZwierzecia: String):Boolean =
    if listaZwierzat.length==0 then
      println("pustaObora")
      return false
    for (zwierzak <- listaZwierzat) {
      if zwierzak.imie == imieZwierzecia then
        listaZwierzat= listaZwierzat diff List(zwierzak)
        println("wykwateruje "+zwierzak.toString)
        return true
    }
    println("brak zwierzecia o tym imieniu")
    false

  def przenies(imieZwierzecia: String,obora: Obora):Boolean =
    for (zwierzak <- listaZwierzat){
      if zwierzak.imie == imieZwierzecia then
        if obora.zakwateruj(zwierzak) then
          if wykwateruj(zwierzak.imie) then
            println("przenosze "+zwierzak.toString)
            return true
          else
            obora.wykwateruj(zwierzak.imie)
            return false
    }
    println("brak o takim imieniu")
    false


  def wyswietl():Unit =
    println()
    println("Obora nr:"+ nrObory+" Pana: "+wlasciciel)
    for (zwierz <- listaZwierzat) println(zwierz.toString)
    println()
}

class Zwierzak (val gatunek:String,val imie:String,val rokUrodzenia:Int){
  override def toString:String =
    gatunek+" "+imie+" rokUrodzenia:"+rokUrodzenia
}

def testObora():Unit =
  val obora1 = new Obora ("Marian", 3)
  val obora2 = new Obora ("Mariusz", 2)
  val z1 = new Zwierzak("pies","burek", 2000)
  val z2 = new Zwierzak("kot","mruczek", 2001)
  val z3 = new Zwierzak("krowa","halina", 2002)
  val z4 = new Zwierzak("kon","bartek", 2003)
  val z5 = new Zwierzak("pies","burekJunior", 2001)
  obora1.zakwateruj(z1)
  obora1.zakwateruj(z2)
  obora1.zakwateruj(z3)
  obora1.zakwateruj(z4) //brak miejsc
  obora1.wyswietl()
  obora2.zakwateruj(z4)
  obora2.zakwateruj(z5)
  obora2.przenies("burek",obora1)
  obora1.wyswietl()
  obora2.wyswietl()
  obora2.wykwateruj("bartek")
  obora2.wyswietl()
  obora1.przenies("mruczek",obora2)
  obora1.wyswietl()
  obora2.wyswietl()
  obora2.przenies("halina",obora1)
  obora1.wyswietl()
  obora2.wyswietl()
  obora2.wykwateruj("burekJunior")
  obora2.wykwateruj("mruczek")
  obora2.wykwateruj("burekJunior")