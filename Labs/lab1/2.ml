let rec silnia n = 
    if n=0 then 1. 
    else float_of_int( n)*.silnia(n-1);;

let rec potega (x,p)=
  if p=(-1)&& p mod 2=0 then 1.
  else if(p=(-1) && p mod 2<>0) then -1.
  else if p=1 then x 
  else  x*.potega(x,p-1);;


let rec suma(n,x) = 
    if (n = 1)then (-1.*.x)
    else (potega(-1., n) *. potega(x, n) )/. silnia(n) +.suma(n - 1, x) ;;
  

suma(5,3.);;
