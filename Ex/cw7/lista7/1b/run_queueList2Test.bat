ocamlc -c queue_fun2.mli 
ocamlc -c queueList2.ml
ocamlc -c queueTest2.ml
ocamlc -o queueTest2 queueList2.cmo queueTest2.cmo
ocamlrun queueTest2
