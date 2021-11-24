def function1[A](xs:List[A=>A]):(A=>A) =

  def fHelp[A](ys:List[A=>A],accum:(A=>A)):(A=>A)=
    ys match
      case Nil => accum
      case h::t => fHelp(t, accum compose h)

  fHelp(xs,x=>x)

function1(List(Math.cos,Math.sin,Math.cos))(0)
function1(List(((x:Double)=>x*x),((x:Double)=>x+x)) )(4)

def function1_2[A](xs:List[A=>A]):(A=>A) =
  def f(x: A) = x
  xs.foldLeft(f)((accum,item)=> accum compose item)

function1_2(List(((x:Double)=>x*x),((x:Double)=>x+x)) )(4)
function1_2(List(Math.cos,Math.sin,Math.cos))(0)