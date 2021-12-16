
type 'a llist = LNil | LCons of 'a * 'a llist Lazy.t;;

let rec lfrom k = LCons (k, lazy (lfrom (k+.1.)));;

let rec ltake = function
    (0, _) -> []
 |  (_, LNil) -> []
 |  (n, LCons(x, lazy xs)) -> x :: ltake(n-1, xs);;

let rec toLazyList = function
    [] -> LNil
  | x :: xs -> LCons(x, lazy (toLazyList xs));;

let function1 xss =
  let rec add (x,n) =
    if n=0. then 0.
    else x**n +. add(x,n-.1.)in

  let rec  fHelp(yss,n) =
    match (yss,n) with
       (LNil,_) -> LNil
     | (LCons(h,lazy t),i) ->LCons(add(h,i),lazy(fHelp(t,i+.1.)))in


  fHelp(xss,1.);;


ltake(5, (function1(toLazyList [1.;2.;3.;5.;5.])));;
ltake (15,(function1(lfrom 1.)));;
