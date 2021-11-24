//Maciej Makara
// zadanie 1
def whileLoop(condition: =>Boolean)(expression: =>Unit): Unit =
  if condition then
    expression
    whileLoop(condition)(expression)

var count = 0

whileLoop(count < 3)({
  println(count)
  count += 1
})

//zadanie 2
def swap(tab: Array[Int])(i: Int)(j: Int) =
  val aux = tab(i)
  tab(i) = tab(j)
  tab(j) = aux

def choose_pivot(tab: Array[Int])(m: Int)(n: Int) = tab((m+n)/2)

def partition(tab: Array[Int])(l: Int)(r: Int) =
  var i = l
  var j = r
  val pivot = choose_pivot(tab)(l)(r)
  while (i <= j) do
    while (tab(i) < pivot) i += 1
    while (pivot < tab(j)) j -= 1
    if (i <= j)
      swap(tab)(i)(j)
      i += 1
      j -= 1
  (i, j)



def quick(tab: Array[Int])(l: Int)(r: Int): Unit =
  if l < r then
    val (i, j) = partition(tab)(l)(r)
    if j - l < r - i then
      val _ = quick(tab)(l)(j)
      quick(tab)(i)(r)

    else
      val _ = quick(tab)(i)(r)
      quick(tab)(l)(j)


def quicksort(tab: Array[Int]) = quick(tab)(0)(tab.length - 1)
