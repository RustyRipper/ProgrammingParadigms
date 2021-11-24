def function3(xs:List[Int],x:Int):List[Int] =
  def fHelp(ys:List[Int],accum:List[Int]):List[Int]=
    ys match
      case Nil => if xs==Nil then accum:::List(x) else accum
      case h::t => if h==x then (accum:::List(x,h)):::t
                   else if h<x then if t==Nil then accum:::List(h,x)
                                    else fHelp(t,accum:::List(h))
                   else (accum:::List(x,h)):::t

  fHelp(xs,List())

function3(List(1,3,5,8,9,12),8)
function3(List(2,3,5,8,9),1)
function3(List(2,3,5,8,9),12)
function3(List(),12)

def function3_2(xs:List[Int]):List[Int] =
  def fHelp(ys:List[Int],accum:List[Int]):List[Int]=
    ys match
      case Nil => accum
      case h::t => fHelp(t,function3(accum,h))
  fHelp(xs,List())

function3_2(List(5,2,1,4,6,2))

def function3_3(xs:List[Int],x:Int):List[Int] =
  function3(function3_2(xs),x)

function3_3(List(5,2,1,4,6,2),3)