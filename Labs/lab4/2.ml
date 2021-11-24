let function2 f a b dx krok=
    
    let rec fHelp2 (q,accum)=
       if q>b then  accum
       else  fHelp2(q+.krok  ,((q, ((f(q+.dx)-.f(q))/.dx))::accum) ) in
    fHelp2 (a,[]);;

function2 (fun x->sin x) 0. 3.15 0.000001 0.5;;
    
  
