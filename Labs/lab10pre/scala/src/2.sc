def sumLines(arrayOfArrays:Array[Array[Int]]):Array[Int] =
  def sum(array: List[Int], accum: Int): Int =
    array match
      case h :: t => sum(t, accum + h)
      case _ => accum
  def fHelp(arrays: List[Array[Int]], accum: List[Int]): List[Int] =
    arrays match
      case h :: t => fHelp(t, accum:::List (sum (h.toList, 0) ) )
      case _ => accum

  fHelp(arrayOfArrays.toList, List()).toArray

val array=Array.tabulate(3) ( _ => Array.fill (3) (2))
sumLines(array);;
val array2=Array(Array(1,1,1),Array(2,2,2),Array(3,3,3))
sumLines( array2);;

//-----------------------------------------------------
def sumLinesI(arrayOfArrays:Array[Array[Int]]):Array[Int] =
  val array=Array.tabulate(arrayOfArrays.length)(_*0)
  for i<-1 to arrayOfArrays.length do
    var sum= 0
    for j<-1 to arrayOfArrays(i-1).length do
      sum = sum+ arrayOfArrays(i-1)(j-1);
    array(i-1) = sum

  array

val array3=Array.tabulate(3) ( _ => Array.fill (3) (2))
sumLines(array3);;
val array4=Array(Array(1,1,1),Array(2,2,2),Array(3,3,3))
sumLines( array4);;
