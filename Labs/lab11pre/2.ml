module type QUEUE =
sig 
  type key
  type 'a tk 
  val empty: unit -> key tk
  val first: key tk -> key
  val enqueue: key tk * key -> key tk
  val dequeue: key tk -> key tk
  val isEmpty: key tk -> bool
  val toList: key tk ->  (key * int) list
                         
end;;



module type TYP =
sig
  type t
  val comp: t -> t -> int
end;;

type para = int * int;;

module ParaType: TYP with type t = para =
struct
  type t = para
  let comp p1 p2 = match (p1,p2) with
      ((_,a),(_,b)) -> compare a b
end;;

module IntType: TYP with type t = int =
struct
  type t = int
  let comp i1 i2 = compare i1 i2
end;;

module StringType: TYP with type t = string =
struct
  type t = string
  let comp s1 s2 = compare (String.length s1) (String.length s2)
end;;



module Funktory(Key: TYP) : QUEUE with type key = Key.t = 
struct 
  type key = Key.t
  type 'a tk = KolejkaPusta | Skladowa of Key.t * Key.t tk 
  let empty () = KolejkaPusta
  let rec enqueue (q, x) = 
    match q with
    | KolejkaPusta -> Skladowa(x,KolejkaPusta)
    | Skladowa(h,t) -> Skladowa(h,enqueue (t, x))
  let first q = 
    match q with
    | KolejkaPusta -> failwith "pusta kolejka"
    | Skladowa(h,t) -> h
  let dequeue q =
    match q with
    | KolejkaPusta -> failwith "pusta kolejka"
    | Skladowa(h,t) -> t
  let isEmpty q =
    match q with
    | KolejkaPusta -> true 
    | Skladowa(_,_) -> false 
                         (*
                           let toList f q =
                             let rec fHelp q i =
                               match q with
                               | KolejkaPusta -> []
                               | Skladowa(v,t) -> (v,i)::fHelp t (i+1)
                             in List.sort (fun (a,_) (b,_) -> f a b) (fHelp q 1) *)
  let toList q =
    let rec fHelp q i =
      match q with
      | KolejkaPusta -> []
      | Skladowa(v,t) -> (v,i)::fHelp t (i+1)
    in List.sort (fun (a,_) (b,_) -> Key.comp a b ) (fHelp q 1) 
  
end;;

module IntQueue = Funktory(IntType);;

let q = IntQueue.empty();;
let q = IntQueue.enqueue(q,55);;
IntQueue.first(q);;
let q = IntQueue.enqueue(q,3);;
let q = IntQueue.enqueue(q,22);;


IntQueue.toList q;;

module StringQueue = Funktory(StringType);; 
let s = StringQueue.empty();;
let s = StringQueue.enqueue(s,"1234567");;
let s = StringQueue.enqueue(s,"zupa");;
let s = StringQueue.enqueue(s,"pizza");;

StringQueue.toList s;;

module PairQueue = Funktory(ParaType);;
let p = PairQueue.empty();;
let p = PairQueue.enqueue(p,(1,10));;
let p = PairQueue.enqueue(p,(2,8));;
let p = PairQueue.enqueue(p,(3,6));;
let p = PairQueue.enqueue(p,(4,4));;

PairQueue.toList p;;

