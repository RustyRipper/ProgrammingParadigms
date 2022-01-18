//Maciej Makara

// zadanie 1
class Time(private var hHour: Int) :
  if hHour < 0 then
    hHour = 0

  def hour: Int = hHour
  def hour_=(newHour: Int): Unit =
    if newHour < 0 then
      hHour = 0
    else
      hHour = newHour

//zadanie 2a
class Time2 (private var hHour:Int, private var mMinute:Int) :
  require(hHour>=0 && hHour<24 && mMinute>=0 && mMinute<60)

  def hour: Int = hHour
  def hour_=(newHour:Int):Unit =
    require(newHour>=0  && newHour < 24)
    hHour = newHour
  def minute:Int = mMinute
  def minute_=(newMinute:Int):Unit=
    require(newMinute>=0 && newMinute<60)
    mMinute=newMinute

  def before(other:Time2):Boolean =
    hHour < other.hour || (hHour == other.hour && mMinute < other.minute)

//zadanie 3
class Pojazd(val producent: String, val model: String, val rokProdukcji: Int = -1, var numerRejestracyjny: String = "") :
  println("In the main constructor")

  def this(producent: String, model: String, numerRejestracyjny: String)=
    this(producent, model, -1, numerRejestracyjny)
    println("In the additional constructor nr")



def testPojazd(): Unit =
  val x = new Pojazd("audi","a4")
  val x2 = new Pojazd("bmw","3","DW2")
  val x3 = new Pojazd("opel","corsa",1999)
  val x4 = new Pojazd("audi","a3",2000,"DW1")







