let (+) w1 w2 = 
  let rec fHelp (v1,v2,accum)=
    match (v1,v2) with
      ([],[]) -> accum
    | ([],h::t) -> let newAccum=h::accum in
                   fHelp([],t,newAccum)
    | (h::t,[]) -> let newAccum=h::accum in
                   fHelp(t,[],newAccum)
    | (h::t,h2::t2) ->let newH=h+.h2 in
                      let newAccum=newH::accum in
                      fHelp(t,t2,newAccum)in
  List.rev( fHelp (w1,w2,[]));;
   
[1.;2.]+[2.;3.];;
[1.;2.;3.]+[1.];;
[]+[1.];;

