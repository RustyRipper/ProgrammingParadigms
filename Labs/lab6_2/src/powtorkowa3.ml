type 'a drzewo = Empty | Node of 'a * 'a drzewo * 'a drzewo;;
let t = Node(1,Node(2,Empty,Node(3,Empty,Empty)),Empty);;
let t2 = Node(2,Empty,Node(3,Empty,Empty));;
let t3 = Node(3,Empty,Empty);;
let t4 = Node(4,Empty,Empty);;


let rec function3 t1 t2 =
  match t2 with
    Node(_,l,r) -> if t1=t2 then true
                   else if function3 t1 l then true
                   else if  function3 t1 r then true
                   else false
  | Empty -> false;;

function3 t t2;;
function3 t2 t;;

function3 t3 t2;;
function3 t3 t;;
function3 t t3;;

function3 t4 t;;
function3 t t;;
