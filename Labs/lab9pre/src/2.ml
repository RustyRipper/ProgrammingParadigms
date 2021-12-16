type slowa = int*int;;


let rec function2 xs x =
  match (xs,x) with
  | ([],newOne) -> let (slowo:slowa) = (newOne,1)in
                   [slowo];
  |(((exist,count)::t),newOne) -> if newOne>exist then let (slowo:slowa)= (exist,count) in
                                                       slowo::(function2 t newOne)
                                  else if newOne=exist then let (slowo:slowa)= (exist,count+1) in
                                      slowo::t
                                  else let (slowo:slowa)= (newOne,1)in
                                       slowo::xs;;
                   
let slownik = function2 [] 2;;
let slownik2 = function2 slownik 3;;

let slownik3 = function2 slownik2 2;;
let slownik4 = function2 slownik3 3;;

let slownik5 = function2 slownik4 1;;
let slownik6 = function2 slownik5 1;;
let slownik7 = function2 slownik6 1;;

let slownik8 = function2 slownik7 4;;
