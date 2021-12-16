ocamlc -c queue_mut.mli 
ocamlc -c queueMut.ml
ocamlc -c queueMutTest.ml
ocamlc -o queueMutTest queueMut.cmo queueMutTest.cmo
ocamlrun queueMutTest
