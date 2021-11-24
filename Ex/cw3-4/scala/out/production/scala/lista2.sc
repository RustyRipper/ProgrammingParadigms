//Maciej Makara

// zadanie 2a)
def curry3[A,B,C,D](f1:(A,B,C) => D) = (x:A) => (y:B) => (z:C) => f1(x,y,z)

// zadanie 2b)

def uncurry3[A,B,C,D](f2: A=>B=>C=>D) = (x:A,y:B,z:C) => f2(x)(y)(z)



