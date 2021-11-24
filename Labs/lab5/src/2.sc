def function2[A](xs:List[A],amount:Int,key:A):List[A]=
  def fHelp[A](ys:List[A],n:Int,accum:List[A],flag:Boolean):List[A]=
    (ys,n,flag) match
      case (Nil,_,_) => throw new Exception("zle dane lub brak elementu")
      case (_,0,_)=> accum
      case (h::t,_,true) => fHelp(t,n-1,h::accum,true)
      case (h::t,_,_) => if key==h then fHelp(t,n-1,h::accum,true) else fHelp(t,n,accum,false)
  fHelp(xs,amount,List(),false).reverse

function2(List(1,1,1,2,3,3,5,6,7,9),3,3)
function2(List(1,1,1,2,5,6,7,9),3,3)
function2(List(),3,3)