sealed trait PS[+A]
case class P[+A](m: String, elem: A) extends PS[A]
case class S[+A](m: String) extends PS[A]