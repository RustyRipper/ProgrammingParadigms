let findMinColumn arrayOfArrays =
   let maxW= Array.length arrayOfArrays.(0) in
   let maxH= Array.length arrayOfArrays in
   
   let rec fHelp(i,j,min,accum) = 
     if i=maxW then accum
     else if j=maxH then ( accum.(i) <- min;
             if i = (maxW-1) then  fHelp(i+1, 0, 0, accum)
             else  fHelp(i+1, 0, arrayOfArrays.(0).(i+1), accum))
     else if min>(arrayOfArrays.(j).(i)) then fHelp( i, j+1, arrayOfArrays.(j).(i), accum)
          else fHelp( i, j+1,min, accum) in                                 
                                                 
     
       
   
  fHelp(0,0,arrayOfArrays.(0).(0),Array.init maxW (function i ->i*0));;



let array=Array.init 3 (function _ -> Array.make 3 2);;
findMinColumn array;;
let array2=[|[|1; 1; 1|]; [|2; 0; 2|]; [|3; 3; 0|]|];;
findMinColumn array2;;
let arrayMatrix = [|[|1;2;10|];
                    [|2;5;11|];
                    [|1;5;-3|];
                    [|0;3;-2|]|];;
findMinColumn arrayMatrix;;

let findMinColumnI arrayOfArrays =
  let array=Array.make (Array.length arrayOfArrays.(0)) 0 in
  for i=1 to Array.length arrayOfArrays.(0) do
    let min=ref arrayOfArrays.(0).(i-1) in
    for j=1 to Array.length arrayOfArrays do
      if !min > arrayOfArrays.(j-1).(i-1) then min:= arrayOfArrays.(j-1).(i-1)
    done;
    array.(i-1) <- !min; 
  done;
  array;;

let array3=Array.init 3 (function _ -> Array.make 3 2);;
findMinColumnI array3;;
let array4=[|[|1; 1; 1|]; [|2; 0; 2|]; [|3; 3; 0|]|];;
findMinColumnI array4;;
