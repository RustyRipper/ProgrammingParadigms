

def function1(xs:List[List[Int]]): List[(Int,Int)]=
  xs match
    case Nil => Nil
    case h::t => if h==List() then throw Exception("pusta")
                  else(h.min,h.max) :: function1(t)

function1(List(List(1,2,3,4),List(3,2,5,234),List(-32,4,2,3),List()))

def function2(xs:List[List[Int]]): List[(Int,Int)]=
  xs.map(x => x.foldLeft({if x==Nil then throw Exception("pusta") else x.head},x.head)((min_max,y)=> (math.min(min_max._1,y),math.max(min_max._2,y))))

function2(List(List(1,2,3,4),List(3,2,5,234),List(-32,4,2,3),List()))
