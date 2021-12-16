sealed trait BT[+A]
  case class Node[+A](elem: A,list:List[Node[A]]) extends BT[A]

val t = Node(2, List(
          Node(46,List(
            Node(4,List()))),
          Node(32,List(
            Node(3,List())))))

def checkGraph[A](tree:BT[A]):Boolean=
  def createList(xs:List[Node[A]]):List[A] =
    xs match
      case Nil=> Nil
      case h::t => (h.elem::createList(h.list)):::createList(t)

  def checkList(list:List[A]):Boolean =
    def fHelp2(xs:List[A],accum:List[A] ):Boolean=
      xs match
        case Nil=> false
        case h::t => if accum.contains(h) then true
                      else fHelp2(t,h::accum)
    fHelp2(list,List())

  tree match
    case Node(_,Nil) => true
    case Node(e,xs) => checkList(e::createList(xs))


checkGraph(t)