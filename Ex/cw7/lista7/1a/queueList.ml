(* Maciej Makara*)
(* zadanie 1a*)
	type 'a t = 'a list
		
    exception Empty of string
    
    let empty () = []

    let enqueue (e, q) =
      q @ [e]

    let dequeue = function
      | [] -> []
      | h::t -> t

    let first = function
      | [] -> raise (Empty "module queueList: first")
      | h::t -> h

    let isEmpty q =
      q = []