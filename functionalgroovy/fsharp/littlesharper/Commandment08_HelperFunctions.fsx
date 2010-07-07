

let add1 n = [] :: n 


assert ([] = [])
assert ([ [] ] = add1 [])
assert ([ []; [] ] = add1 [ [] ])
assert ([ []; []; [] ] = add1 [ []; [] ])


let sub1 n = List.tl n 

assert ([ [] ] = sub1 [ []; [] ])
assert ([ []; [] ] = sub1 [ []; []; [] ])

let isZero n = List.isEmpty n 

let rec plus n m = 
    if isZero m then []
    else add1 (plus n (sub1 m))

assert ([ []; [] ] = plus [[]] [[]])
;;