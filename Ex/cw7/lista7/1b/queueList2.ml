(* Maciej Makara*)
(* zadanie 1b*)
    type 'a t = 'a list * 'a list
		
    exception Empty of string
    
    let empty () = ([],[])

    let enqueue (y, q) =
      match q with
      | ([],[]) -> ([y],[])
      | (list,revList) -> (list,y::revList)

    let dequeue q=
      match q with
      | ([],[]) -> ([],[])
      | (_::[],revList) -> (List.rev revList, [])
      | (_::t,revList) -> (t,revList)

    let first q =
      match fst q with 
      | [] -> raise (Empty "module queueList2: first")
      | h::_ ->h

    let isEmpty q =
      fst q = []
	  
    
