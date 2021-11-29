sealed trait Tree[A]
  case class Empty[A]() extends Tree[A]
  case class Leaf[A](elem: A)extends Tree[A]
  case class Node[A](left:Tree[A],right:Tree[A]) extends Tree[A]

val t= Node(Node(Node(Leaf(2),Leaf(1)),Node(Empty(),Leaf(4))),Leaf(3))

def function1[A](key:A,tree:Tree[A]): Boolean =
  val flag = false
  def fHelp[A](tree2:Tree[A],accum:List[A]):List[A] =
    tree2 match
      case Empty() =>Nil
      case Leaf(x) => x::accum
      case Node(l,r) => (fHelp(l,accum):::fHelp(r,accum)):::accum
  if fHelp(tree,List()).contains(key) then true
  else false

function1(5,t)