class Rownanie:
  def rozwiaz( array: Array[Double]): Unit ={
    var newArray=przetworzTablice(array)

    if newArray.length>0
      then
      if newArray.length==1 then
        stopien0(newArray)
      else if newArray.length==2 then
        stopien1(newArray)
      else if newArray.length==3 then
        stopien2(newArray)
    else println("zla implementacja")
  }
  private def przetworzTablice(array: Array[Double]): Array[Double] ={
    var dt= array.length
    var newArray= array
    while dt > 3 do
      if newArray(0) != 0 then
        newArray=Array(1)
        dt=0
      else
        newArray=newArray.tail
        dt=dt-1
    while  newArray.length>1 && newArray(0)==0 do
      newArray=newArray.tail
    newArray
  }
  private def stopien0(array: Array[Double]):Unit={
    if array(0)==0 then
      println("nieskonczenie wiele rozw")
    else println("brak rozw")
  }
  private def stopien1(array: Array[Double]):Unit={
    var a = array(array.length-2)
    var b = array(array.length-1)
    b = b*(-1.0)
    println("x= "+b/a)
  }
  private def stopien2(array: Array[Double]):Unit={
    var a = array(array.length-3)
    var b = array(array.length-2)
    var c = array(array.length-1)
    var delta = b*b - 4*a*c

    if delta < 0.0
      then println(" brak rozw")
    else if delta == 0.0
      then println("x= "+((-1)*b) / (2*a));
    else
      println("x1= "+((-1)*b - math.sqrt(delta))/(2*a))
      println("x2= "+((-1)*b + math.sqrt(delta))/(2*a))
  }

