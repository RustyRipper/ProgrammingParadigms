def function3 (g:Double=>Double, f:Double=>Double)=
  val dx=0.0000001
  def pochodna_f(x:Double)= (f (x+dx)-f(x))/dx
  def pochodna_g(x:Double)= (g (x+dx)-g(x))/dx
  pochodna_g compose pochodna_f

function3 ((x:Double)=> 3*x*x,(x:Double)=> (x*x))
function3 ((x:Double)=> 3*x*x,(x:Double)=> (x*x))(3)
function3 (Math.cos,Math.sin)(0)