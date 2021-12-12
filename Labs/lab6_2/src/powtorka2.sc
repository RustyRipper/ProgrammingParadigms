def function2(xs:List[Double=>Double]):(Double=>Double)=

  def fHelp(ys:List[Double=>Double],accum:Double=>Double):(Double=>Double) =
    ys match
      case Nil => accum
      case h::t => fHelp(t,accum compose h)

  fHelp(xs,x=>x)

function2(List(x=>2*x,x=>3*x,x=>4*x))(3)

def function2FoldLeft(xs:List[Double=>Double]):(Double=>Double) =
  def function(x:Double): Double=>Double = x=>x
  xs.foldLeft(function(1))((accum,item) => item compose accum)

function2FoldLeft(List(x=>2*x,x=>3*x,x=>4*x))(3)