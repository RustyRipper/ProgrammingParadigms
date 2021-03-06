module type OBSLUGA_KOLEJKI =
  sig
    type 'a tk
    exception Pusta of string
    val tworz_pusta: unit -> 'a tk
    val do_kolejki: 'a * 'a tk -> 'a tk
    val z_kolejki: 'a tk -> 'a tk
    val pierwszy_element: 'a tk -> 'a
    val kolejka_pusta: 'a tk -> bool
  end;;

module QUEUEE : OBSLUGA_KOLEJKI =
  struct
    type 'a tk = KolejkaPusta | Skladowa of 'a * 'a tk
                                          
    exception Pusta of string
                     
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
      | KolejkaPusta -> raise (Pusta "module Queuee: pierwszy")
                      
    let kolejka_pusta q = q = KolejkaPusta          
  end;;                     
                                                   
let queuee= QUEUEE.tworz_pusta();;
QUEUEE.kolejka_pusta(queuee);;
let q= QUEUEE.(do_kolejki(2,do_kolejki(1,tworz_pusta())));;
QUEUEE.kolejka_pusta(q);;
QUEUEE.pierwszy_element(q);;
let q2=QUEUEE.do_kolejki(3,q);;
QUEUEE.pierwszy_element(q2);;
QUEUEE.pierwszy_element(QUEUEE.z_kolejki(q2));;
QUEUEE.pierwszy_element(QUEUEE.z_kolejki(QUEUEE.z_kolejki(q2)));;
QUEUEE.pierwszy_element(QUEUEE.z_kolejki(QUEUEE.z_kolejki(QUEUEE.z_kolejki(q2))));;
QUEUEE.kolejka_pusta(QUEUEE.z_kolejki(QUEUEE.z_kolejki(QUEUEE.z_kolejki(q2))));;
