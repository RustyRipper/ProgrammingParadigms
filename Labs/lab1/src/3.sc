
def suma(n: Int): Double = {
  if (n == 1) 1
  else   +suma(n - 1)
}

suma(3,3)
