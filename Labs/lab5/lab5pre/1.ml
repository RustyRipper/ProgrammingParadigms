let function2 xs ys =
  let z=List.hd xs+List.hd ys in
  let rec fHelp (xss, yss) accum =
    match (xss,yss) with
      ([],_) -> accum 
    | (_,[]) -> accum 
    | (h::t,h1::t1) -> if h=h1 then fHelp(t,t1) (h::accum) 
                       else if h>h1 then fHelp(xss,t1) accum 
                       else fHelp(t,yss) accum in
  
  fHelp (List.sort (fun a b-> if a=b then 0 else if a>b then 1 else -1) xs, List.sort compare ys) [];;

function2 [12;1;3;4;2;3;7;] [2;4;1;7;3;9];;
