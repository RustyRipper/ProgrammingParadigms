let function1 xs=
  if xs=[] then raise (Failure "blad")
  else 
    let rec fHelp(xs,accum) =
      match xs with
        [] -> accum
      | h::t -> if h < fst accum then fHelp( t,(h,snd accum))
                else if  h>snd accum then fHelp( t,(fst accum,h))
                else  fHelp( t,accum) in
    fHelp (xs, (List.hd xs, List.hd xs));;

function1 [1;2;5;2;3];;
function1 [];;


let function3 xs =
  if xs=[] then raise (Failure "blad")
  else  let x=List.hd xs in
        List.fold_left(fun (min,max) h ->( if h< min then (h,max) else if h>max then (min,h) else (min,max))) (x, x) xs;;
  


function3 [1;2;5;2;3];;
function3 [1];;
