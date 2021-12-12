module type QUEUE_FUN =
  sig
    type 'a t
    exception Empty of string
    val empty: unit -> 'a t
    val enqueue: 'a * 'a t -> 'a t
    val dequeue: 'a t -> 'a t
    val first: 'a t -> 'a
    val isEmpty: 'a t -> bool
  end;;

module QueueList : QUEUE_FUN =
  struct
    type 'a t = 'a list
		
    exception Empty of string
    
    let empty () = []

    let enqueue (element, queue) =
      queue @ [element]

    let dequeue = function
      | [] -> []
      | head :: tail -> tail

    let first = function
      | [] -> raise (Empty "module ListQueue: first")
      | head :: tail -> head

    let isEmpty queue =
      queue = []
  end;;




let q = QueueList.empty();;
QueueList.isEmpty(QueueList.enqueue(2, q)) = false;;
