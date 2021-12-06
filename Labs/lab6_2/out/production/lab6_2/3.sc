sealed trait Tree[A]

  case class Leaf[A](elem: A)extends Tree[A]
  case class NodeOne[A](one:Tree[A]) extends Tree[A]
  case class Node[A](left:Tree[A],right:Tree[A]) extends Tree[A]

val t= Node(Node(Node(Leaf(2),Leaf(1)),NodeOne(Leaf(4))),Leaf(3))

sealed trait PS[+A]
  case class P[+A](napis: String, elem: A) extends PS[A]
  case class S[+A](napis: String) extends PS[A]

def function3[A](tree:Tree[A]):List[PS[A]] =
  def fHelp[A](treeTemp:Tree[A]): PS[A] =
    treeTemp match
      case Leaf(value) => P("Dana",value)
      case NodeOne(one)=> one match
        case (Leaf(_)) => S("Wezel ,(element)")
        case (_) => S("Wezel ,(one)")
      case Node(left,right) => (left,right) match
        case (Leaf(_),Leaf(_)) => S("Wezel ,(element,element)")
        case (_,Leaf(_)) => S("Wezel ,(lewo,element)")
        case (Leaf(_),_) => S("Wezel ,(element,prawo)")
        case (_,_) => S("Wezel ,(lewo,prawo)")

  def fHelp2[A](treeTemp:Tree[A], accum:List[PS[A]]):List[PS[A]] =
    treeTemp match
      case Leaf(value) => P("Dana",value)::accum
      case NodeOne(one) => (fHelp2(one,accum):::List(fHelp(treeTemp))):::accum
      case Node(left,right) => ((fHelp2(left,accum):::fHelp2(right,accum)):::List(fHelp(treeTemp))):::accum

  fHelp2(tree,List())

function3(t)



