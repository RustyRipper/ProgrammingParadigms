val lazylist1 = LazyList[Int](1,2,3,5,5)

def function1[A](xss:LazyList[A])(f1:Int=>Int):LazyList[A] =

  def fHelp[A](yss:LazyList[A],n:Int,counter:Int):LazyList[A] =
    (yss,n,counter) match
      case (LazyList(),_,_) => LazyList()
      case (h#::t,i,0) => fHelp(t,i+1,f1(i+1))
      case (h#::t,i,c) => h#::fHelp(yss,i,c-1)

  fHelp(xss,1,f1(1))

function1(lazylist1)(x=>2*x).toList