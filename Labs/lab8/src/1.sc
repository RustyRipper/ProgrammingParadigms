sealed trait BT[+A]
case object Empty extends BT[Nothing]
case class Node[+A](elem: A, left: BT[A], right: BT[A]) extends BT[A]


val t = Node(List(1, 2, 3), Node(List(1, 2), Empty, Node(List(4, 3), Empty, Empty)), Empty)

def sumListToTree(tree:BT[List[Int]]):BT[Int] =

  def sumList(xs: List[Int]):Int =
    xs match
      case Nil => 0
      case h::t => h+sumList(t)

  def fHelp(tree2:BT[List[Int]]):BT[Int]=
    tree2 match
      case Empty => Empty
      case Node(xs,l,r) => Node(sumList(xs),fHelp(l),fHelp(r))

  fHelp(tree)

sumListToTree(t)
