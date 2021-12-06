type litera = Zawiera| Niezawiera ;;
type dane_slow = Empty | Short of litera | Medium of litera | Long of litera;;

let function1 xs x =
  let rec fHelp ys accum=
    match ys with
      [] -> accum
    | h::t -> let xx =(if String.contains(h)(x)then Zawiera else Niezawiera) in
              if (String.length h)<=10 then fHelp(t)(Short(xx)::accum)
              else if ( (String.length h)>10 && (String.length h)<=20) then fHelp (t) (Medium(xx)::accum)
              else  fHelp( t) (Long(xx)::accum) in
  List.rev( fHelp(xs)([]));;

function1 ["raz";"dwadziescia";"bardzoDlugiNapisNaPewnoLong"] 'd';;

