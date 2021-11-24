let function1(a,b,c)= 
  if(a<0. || b<0. ||c<0.)then raise (Failure "ujemny bok")
  else if (abs_float(b-.c))>a || a>(b+.c)then raise(Failure "to nie trojkat") 
       else let p=((a+.b+.c)/.2.)
            in sqrt(p*.(p-.a)*.(p-.b)*.(p-.c));;
  
  
       

function1 (1., 1., 1.);;
function1 -1. 2. 2.;;
function1(4.,1.,1.);;
