def findMinColumn(arrayOfArrays:Array[Array[Int]]):Array[Int] =
  val maxW:Int = arrayOfArrays(0).length
  val maxH:Int = arrayOfArrays.length

  def fHelp(i:Int,j:Int,min:Int, accum:Array[Int]): Array[Int] =
    (i,j) match
      case (`maxW`, 0) => accum
      case (x, `maxH`) => accum(x) = min
                          fHelp(x + 1, 0, if x==maxW-1 then 0 else arrayOfArrays(0)(x+1), accum)
      case (x, y) => fHelp(x, y + 1, if min > arrayOfArrays(y)(x) then arrayOfArrays(y)(x) else min, accum)

  fHelp(0,0,arrayOfArrays(0)(0),Array.tabulate(arrayOfArrays(0).length)(_*0))

val array=Array.tabulate(3) ( _ => Array.fill (3) (2))
findMinColumn(array);;
val array2=Array(Array(1,1,1),Array(2,0,2),Array(3,3,0))
findMinColumn( array2);;
val arrayMatrix = Array(Array(1,2,10),
                        Array(2,5,11),
                        Array(1,5,-3),
                        Array(0,3,-2))
findMinColumn(arrayMatrix);;
//-----------------------------------------------------
def findMinColumnI(arrayOfArrays:Array[Array[Int]]):Array[Int] =
  val array=Array.tabulate(arrayOfArrays(0).length)(_*0)

  for i<-1 to arrayOfArrays(0).length do
    var min=arrayOfArrays(0)(i-1)
    for j<-1 to arrayOfArrays.length do
      if min > arrayOfArrays(j-1)(i-1) then min = arrayOfArrays(j-1)(i-1)

    array(i-1)= min

  array

val array3=Array.tabulate(3) ( _ => Array.fill (3) (2))
findMinColumnI(array3);;
val array4=Array(Array(1,1,1),Array(2,0,2),Array(3,3,0))
findMinColumnI( array4);;
