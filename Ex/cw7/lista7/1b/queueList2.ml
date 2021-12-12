(* Maciej Makara*)
(* zadanie 1b*)
    type 'a t = 'a list * 'a list
		
    exception Empty of string
    
	let repair = function
      | ([], revQ) -> (List.rev revQ, [])
      | q -> q

	
    let empty () = ([],[])

    let enqueue (y, q) =
      repair(fst q, y::snd q)

    let dequeue = function
      | ([],_) -> ([],[])
      | (_::t,yl) -> repair(t,yl)

    let first q =
      match fst q with 
      | [] -> raise (Empty "module ListQueue2: first")
      | h::_ ->h

    let isEmpty q =
      fst q = []
	  
    