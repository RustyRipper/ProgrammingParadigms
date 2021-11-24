def function1(a:Double, b:Double,c:Double):Double={
  if (a<0 || b<0||c<0) throw new Exception("ujemny bok")
  else if(math.abs(b-c)>a || a>(b+c))throw new Exception("to nie trojkat")
  else{
    val p=((a+b+c)/2)
    math.sqrt(p*(p-a)*(p-b)*(p-c))
  }
}
function1(1,1,1)
function1(-1,2,2)
function1(4,1,1)