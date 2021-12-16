val lazylist1 = LazyList[Double](1,2,3,5,5)

def function1(xss:LazyList[Double]):LazyList[Double] =
  def add(x:Double,n:Int):Double =
    if n==0 then 0
    else Math.pow(x,n)+add(x,n-1)

  def fHelp(yss:LazyList[Double],n:Int):LazyList[Double] =
    (yss,n) match
      case (LazyList(),_) => LazyList()
      case (h#::t,i) => add(h,i)#::fHelp(t,i+1)


  fHelp(xss,1)


function1(lazylist1).toList