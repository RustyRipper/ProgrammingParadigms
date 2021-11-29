//Maciej Makara
//zadanie 1

def whileLoop(condition: =>Boolean)(actions: =>Unit):Unit =
  if condition then
    actions
    whileLoop(condition)(actions)


var count = 0
whileLoop (count < 3)({
  println(count)
  count += 1})


//zadanie2
def swap(tab:Array[Int])(i:Int)(j:Int) =
  val aux = tab(i)
  tab(i) = tab(j)
  tab(j) = aux

def choose_pivot (tab:Array[Int])(m:Int)(n:Int) =
  tab((m+n)/2)

def partition (tab:Array[Int])(l:Int)(r:Int)=
  var i=l
  var j=r
  val pivot=choose_pivot(tab)(l)(r)
  while i <= j do
    while tab(i) < pivot do i+=1
    while pivot < tab(j) do j-=1
    if i <= j then
      swap(tab)(i)(j)
      i+=1
      j-=1
  (i,j)

def quick (tab:Array[Int])(l:Int)(r:Int):Unit =
  if l < r then
    val (i,j) = partition(tab)(l)(r)
    if j-l < r-i then
      quick(tab)(l)(j)
      quick(tab)(i)(r)
    else
      quick(tab)(i)(r)
      quick(tab)(l)(j)


def quicksort (tab:Array[Int]) =
  quick(tab)(0)(tab.length-1)

val t1 = Array(4,8,1,12,7,3,1,9)

quicksort(t1)
t1