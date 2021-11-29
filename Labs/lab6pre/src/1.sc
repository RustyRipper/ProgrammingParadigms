sealed trait plec
  case object Kobieta extends plec
  case object Mezczyzna extends plec

type osoba =(String,String)

val os1: osoba = ("Brzechwa","Jan")
val os2: osoba = ("Brzechwa","Janina")


def manOrWoman(osoba:osoba):plec =
  if osoba._2.last == 'a' then Kobieta
  else Mezczyzna

manOrWoman(os1)
manOrWoman(os2)