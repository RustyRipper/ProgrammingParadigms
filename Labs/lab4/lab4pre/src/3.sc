def function3(g:Double=>Double, f:Double=>Double,x:Double)=
  val dx=0.0000001
  val pochodna_f = (x:Double) => (f (x+dx)-f(x))/dx
  val pochodna_g = (x:Double) => (g (x+dx)-g(x))/dx
  pochodna_f compose pochodna_g


function3 ((x:Double)=> 2*x,(x:Double)=> (4*x),2)
