type samochod = string * string * int;;
type samochody =  samochod list;;


let samochody:samochody =[("Opel"," astra", 2001); ("Renault", "megane", 2001); ("Toyota"," avensis", 2009); ("Nissan", "micra", 2003)];;


let k3_3 (x,y,z) = z;;

let najstarszeSamochody samochody=
  let oldOne = List.fold_left (fun acc x->  if acc>=(k3_3 x) then k3_3 x
                               else acc) (k3_3( List.hd samochody))( samochody) in
  List.filter  (fun x ->  (k3_3 x)=oldOne) samochody;; 

najstarszeSamochody samochody;;