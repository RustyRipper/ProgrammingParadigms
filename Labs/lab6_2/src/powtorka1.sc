def function1(dokl:Double):Double=
  def fSuma(n:Int,i:Double):Double =
    if i<=n then (1/i)+fSuma(n,i+1)
    else 0

  def fCn(n:Int):Double =
    fSuma(n,1)-Math.log(n)

  def fHelp(n:Int):Double=
    val e=fCn(n+1)
    val prevE =fCn(n)

    if (Math.abs(e-prevE)<dokl) then e
    else fHelp(n+1)

  fHelp(1)

function1(0.000000001)



