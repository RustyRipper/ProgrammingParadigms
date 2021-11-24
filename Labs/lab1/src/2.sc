def silnia(n:Int): Int = {
  if n==0 then 1 else n*silnia(n-1)
}
def suma(n: Int, x: Double): Double = {
    if (n == 1) -x
    else  ((Math.pow(-1, n) * Math.pow(x, n) )/ silnia(n)) +suma(n - 1, x)
}

suma(5,3)
