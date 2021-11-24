def function1[A](xs:List[A]):List[A]=
  def fHelp[A](ys:List[A]):List[A]=
    ys match
      case Nil => Nil
      case h::t => if t==Nil then h::fHelp(t) else if h==t.head  then fHelp(t) else h::fHelp(t)
  fHelp(xs)
function1(List(1,1,2,2,3,6,6,6,9))
