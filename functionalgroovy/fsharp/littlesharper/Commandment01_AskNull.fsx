let rec size lat = 
    if List.length lat = 0 then 0
    else 1 + size(List.tl lat)

assert (0 = size [])
assert (1 = size(["apples"]))
assert (3 = size(["apples", "oranges", "pears"]))

let rec size2 lat = 
    match List.length lat with 
    | 0 -> 0
    | _ -> 1 + size2(List.tl lat)

assert (0 = size2 [])
assert (1 = size2(["apples"]))
assert (3 = size2(["apples", "oranges", "pears"]))
    
let rec isMember a lat = 
    if List.isEmpty lat then false
    elif (List.hd lat) = a then true
    else 
        isMember a (List.tl(lat))

assert (isMember 3 [1; 2; 3; 4; 5])
assert ((isMember 66 [1; 2; 3; 4; 5]) = false)

let rec isMember2 a lat = 
    match lat with 
    | [] -> false
    | head :: _ when head = a -> false
    | _ :: tail -> isMember2 a tail

assert (isMember2 3 [1; 2; 3; 4; 5])
assert ((isMember2 66 [1; 2; 3; 4; 5]) = false)

let isMember3 a lat = 
    let rec inner lat = 
        match lat with 
        | [] -> false
        | head :: _ when head = a -> false
        | _ :: tail -> inner tail
    inner lat

assert (isMember3 3 [1; 2; 3; 4; 5])
assert ((isMember3 66 [1; 2; 3; 4; 5]) = false)

printfn "Success";; 
