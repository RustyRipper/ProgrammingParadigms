type 'a bt = Empty | Node of 'a * 'a bt * 'a bt;;
let t = Node(1,Node(2,Empty,Node(3,Empty,Empty)),Empty);;
let t2 = Node(2,Empty,Node(3,Empty,Empty));;
let t3 = Node(3,Empty,Empty);;

let t4 = Node(4,Empty,Empty);;
let t4copy = Node(4,Empty,Empty);;
let t5= Node(4,Node(4,Empty,Empty),Node(4,Empty,Empty));;
let t6= Node(4,Node(4,Node(4,Empty,Empty),Node(4,Empty,Empty)),Node(4,Node(4,Empty,Empty),Node(4,Empty,Empty)));;

let rec function1 t1 t2 = t1=t2

function1 t4 t;;
function1 t t;;
function1 t4 t4copy;;



let rec function2 t1 t2 =
  match t2 with
    Node(_,l,r) -> if t1=t2 then true
                   else if function2 t1 l then true
                   else if  function2 t1 r then true
                   else false
  | Empty -> false;;

function2 t t2;;
function2 t2 t;;

function2 t3 t2;;
function2 t3 t;;
function2 t t3;;

function2 t4 t;;
function2 t t;;

let rec function3 t1 t2 =
  match t2 with
    Node(_,l,r) -> if t1=t2 then 1+function3 t1 l + function3 t1 r
                   else function3 t1 l + function3 t1 r
  | Empty -> 0;;

function3 t t2;;
function3 t2 t;;
function3 t4 t5;;
function3 t4 t6;;
