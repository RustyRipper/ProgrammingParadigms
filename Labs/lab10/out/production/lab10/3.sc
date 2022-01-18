def findMinColumnI(arrayOfArrays:Array[Array[Int]]):Array[Int] =
  val array=Array.tabulate(arrayOfArrays(0).length)(_*0)
  for i<-1 to arrayOfArrays(0).length do
    var min=arrayOfArrays(0)(i-1)
    for j<-1 to arrayOfArrays.length do
      if min > arrayOfArrays(j-1)(i-1) then min = arrayOfArrays(j-1)(i-1)
      else min = min
    array(i-1)= min

  array

val array3=Array.tabulate(3) ( _ => Array.fill (3) (2))
findMinColumnI(array3);;
val array4=Array(Array(1,1,1),Array(2,2,2),Array(3,3,3))
findMinColumnI( array4);;