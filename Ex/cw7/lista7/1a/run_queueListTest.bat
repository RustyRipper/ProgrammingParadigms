ocamlc -c queue_fun.mli 
ocamlc -c queueList.ml
ocamlc -c queueTest.ml
ocamlc -o queueTest queueList.cmo queueTest.cmo
ocamlrun queueTest
