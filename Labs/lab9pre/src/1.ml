
type 'a llist = LNil | LCons of 'a * 'a llist Lazy.t;;

let rec lfrom k = LCons (k, lazy (lfrom (k+1)));;

let rec ltake = function
    (0, _) -> []
 |  (_, LNil) -> []
 |  (n, LCons(x, lazy xs)) -> x :: ltake(n-1, xs);;

let rec toLazyList = function
    [] -> LNil
  | x :: xs -> LCons(x, lazy (toLazyList xs));;
(*-------------------------------------------------*)
let function1 xss f1 =
 
  let rec fHelp(yss,n,counter) =
    match (yss,n,counter) with
       (LNil,_,_) -> LNil
     | (LCons(h,lazy t),i,0) -> fHelp(t,i+1,f1(i+1))       
     | (LCons(h,lazy t),i,c) -> LCons(h,lazy(fHelp(yss,i,c-1)))in

  fHelp(xss,1,f1(1));;

(*-------------------------------------------------*)
ltake(30, (function1 (toLazyList [1;2;3;5;5])( fun x->2*x)));;
ltake (100,(function1(lfrom 1)(fun x->2*x)));;
