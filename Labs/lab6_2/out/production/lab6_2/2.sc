type Samochod = (String,String,Int)

type Samochody= List[Samochod]

val lista:Samochody = List(("Opel", "astra", 1999), ("Renault", "megane", 2004), ("Opel", "corsa", 2009), ("Nissan", "micra", 2004), ("Opel", "corsa", 2009), ("Nissan", "micra", 2003))


def usunPowtorzenia(list:List[(String,Int)]):List[(String,Int)] =
  def fHelp2(xs:List[(String,Int)],accum:List[(String,Int)] ):List[(String,Int)]=
    xs match
      case Nil=> accum
      case h::t => if accum.contains(h) then fHelp2(t,accum)
                   else fHelp2(t,h::accum)
  fHelp2(list,List())

def function1(samochody:Samochody):List[(String,Int)]=
  def fHelp(samochody:Samochody,accum:(String,Int)):(String,Int) =
    samochody match {
      case Nil => accum
      case h::t => if h._1==accum._1 then fHelp(t,(accum._1,accum._2+1))
                   else fHelp(t,accum)
    }
  val x=samochody.foldLeft(List[(String,Int)]())((sum,item)=> fHelp(samochody,(item._1,0))::sum)


  usunPowtorzenia(x)


function1(lista)