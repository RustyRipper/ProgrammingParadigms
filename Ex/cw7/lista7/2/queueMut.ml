(* Maciej Makara *)
(* zadanie 2 *)
type 'a t = {mutable f: int; mutable r: int; array: 'a option array}
          
exception Empty of string
exception Full of string

let empty n = {f = 0; r = 0; array = Array.make (n + 1) None}
            
let isEmpty q =
  q.f = q.r
            
let isFull q =
   ((q.r + 1) mod (Array.length q.array)) = q.f
         
let enqueue(x, q) =
  if isFull q then raise (Full "full queue")
  else
    begin
      q.array.(q.r) <- Some x;
      q.r <- (q.r + 1) mod (Array.length q.array)
    end
                          
let dequeue q =
  if not(isEmpty q) then q.f <- (q.f + 1) mod (Array.length q.array)
   

let first q =
  if isEmpty q then raise (Empty "empty queue")
  else match q.array.(q.f) with
       | Some e -> e
       | None -> raise (Empty "module QueueMut: first ( implementation error!)")


