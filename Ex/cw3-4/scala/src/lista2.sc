//Maciej Makara
import scala.language.postfixOps
// zadanie 2a)
def curry3[A,B,C,D](f1:(A,B,C) => D) = (x:A) => (y:B) => (z:C) => f1(x,y,z)

// zadanie 2b)

def uncurry3[A,B,C,D](f2: A=>B=>C=>D) = (x:A,y:B,z:C) => f2(x)(y)(z)

// zadanie 3
//def foldLeft[B](z: B)(op: (B, A) => B): B
def sumProd(xs:List[Int]): (Int,Int) =
  xs match
    case h :: t => xs.foldLeft(0, 1)((s_p, h) => (s_p._1 + h, s_p._2* h))
    case Nil => (0, 0)



sumProd(List(5,4,3)) == (12,60)
sumProd(List()) == (0,0)



