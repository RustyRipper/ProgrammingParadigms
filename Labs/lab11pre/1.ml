module type QUEUE =
  sig 
    type value
    type 'a tk 
    val tworz_pusta: unit -> value tk
    val pierwszy_element: value tk -> value
    val do_kolejki:  value * value tk -> value tk
    val z_kolejki: value tk -> value tk
    val kolejka_pusta: value tk -> bool
    val print_list: value tk -> value list 
    val to_list_position: value tk ->  (value * int) list
                         
  end;;


module QUEUE_F(F :sig type t val compare1: t-> t->int end):(QUEUE with type value=F.t) =  
  struct
    type value= F.t
    type 'a tk=KolejkaPusta| Skladowa of F.t * F.t tk
                                          
                     
    let tworz_pusta() = KolejkaPusta
                      
    let rec do_kolejki(e,q) =
      match q with
      | Skladowa(h,KolejkaPusta)->Skladowa(h,Skladowa(e, KolejkaPusta))
      | KolejkaPusta -> Skladowa(e,KolejkaPusta)
      | Skladowa(h,rest) -> Skladowa(h, do_kolejki(e,rest))
                          
      
    let z_kolejki = function
      | Skladowa(_,restOfQueuee) -> restOfQueuee
      | KolejkaPusta -> KolejkaPusta
                      
    let pierwszy_element= function
      | Skladowa(e,_) -> e
      | KolejkaPusta -> failwith ( "module Queuee: pierwszy")
                      
    let kolejka_pusta q = q = KolejkaPusta
                        
    let rec print_list = function 
      |  KolejkaPusta -> []
      |  Skladowa(h,rest) -> [h]@print_list rest
                           
    let to_list_position q =
     let rec fHelp q i =
       match q with
       | KolejkaPusta -> []
       | Skladowa(e,rest) -> [(e,i)]:::fHelp rest (i+1) in
     List.sort (fun (a,_) (b,_) -> F.compare1 a b ) (fHelp q 1)                         
  end;;



module Int =
  struct
    type t = int
    let compare1 a b =
      compare a b
  end;;

module ParaInt =
  struct
    type t = int * int;;
    let compare1 aa bb =
      match (aa,bb) with
        ((a,_),(b,_)) -> compare a b
  end;;

(*------------------------------------------------*)
module IntQUEUE= QUEUE_F(Int);;

let q = IntQUEUE.tworz_pusta();;
IntQUEUE.kolejka_pusta(q);;
let q = IntQUEUE.do_kolejki(3,q);;
let q = IntQUEUE.do_kolejki(2,q);;

IntQUEUE.pierwszy_element(q);;

let q = IntQUEUE.z_kolejki(q);;
let q = IntQUEUE.do_kolejki(1,q);;
let q = IntQUEUE.do_kolejki(0,q);;

IntQUEUE.kolejka_pusta(q);;

IntQUEUE.print_list q;;
IntQUEUE.to_list_position q;;
(*------------------------------------------------*)

module ParaIntQUEUE = QUEUE_F(ParaInt);;

let q3 = ParaIntQUEUE.tworz_pusta();;
ParaIntQUEUE.kolejka_pusta(q3);;
let q3 = ParaIntQUEUE.do_kolejki((3,3),q3);;
let q3 = ParaIntQUEUE.do_kolejki((2,2),q3);;

ParaIntQUEUE.pierwszy_element(q3);;

let q3 = ParaIntQUEUE.z_kolejki(q3);;
let q3 = ParaIntQUEUE.do_kolejki((1,1),q3);;
let q3 = ParaIntQUEUE.do_kolejki((0,1),q3);;

ParaIntQUEUE.kolejka_pusta(q3);;

ParaIntQUEUE.print_list q3;;
ParaIntQUEUE.to_list_position q3;;
