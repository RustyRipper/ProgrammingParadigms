type plec = Mezczyzna | Kobieta;;
 

type osoba = string * string;;

let (os1: osoba) = ("Brzechwa","Jan");;
let (os2: osoba) = ("Brzechwa","JaninA");;


let manOrWoman osoba =
  let index= String.length (snd osoba) in
  
  if (String.lowercase (snd osoba)).[index-1] = 'a' then Kobieta
  else Mezczyzna;;
  
  
manOrWoman os1;;
manOrWoman os2;;