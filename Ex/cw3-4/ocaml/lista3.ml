(* Maciej Makara *)

(*zadanie 2 a)*)
let curry3 f1 x y z = f1(x,y,z);;
let curry3_2 = function f2 -> function x-> function y-> function z -> f2(x,y,z);;

(*zadanie 2 b)*)
let uncurry3 f1(x,y,z) = f1 x y z;;
let uncurry3_2 =  function f2 -> function (x,y,z) -> f2 x y z;;


(*zadanie 3 *)
(* val fold_left : ('a -> 'b -> 'a) -> 'a -> 'b list -> 'a *)
      
let sumProd xs =
  match xs with
    h::t ->  List.fold_left(fun(s,p) h-> (s+h,p*h)) (0,1) xs
  | [] -> (0,0);;
 

sumProd [5;4;3] = (12,60);;
sumProd [] = (0,0);;

(* zadanie 4*)
let rec quicksort = function
 [] -> []
 | [x] -> [x]
 | xs -> let small = List.filter (fun y -> y < List.hd xs ) xs
 and large = List.filter (fun y -> y >= List.hd xs ) xs
 in quicksort small @ quicksort large;;

(*quicksort [2;3;3;5;1];; stack overflow*)
                         
 let rec quicksort' = function
 [] -> []
 | x::xs -> let small = List.filter (fun y -> y < x ) xs
 and large = List.filter (fun y -> y > x ) xs
 in quicksort' small @ (x :: quicksort' large);;

                         
quicksort' [2;3;3;5;1]=[1;2;3;5];;
