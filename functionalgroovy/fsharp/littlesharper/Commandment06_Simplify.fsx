
let isMember a list = 
    let rec inner lat = 
        if List.isEmpty lat then false
        elif List.hd lat = a then true
        else inner (List.tl lat)
    inner list

assert (isMember 3 [1; 2; 3; 4; 5])
assert ( false = isMember 66 [1; 2; 3; 4; 5])


let replace _new old list = 
    let rec inner lat = 
        if List.isEmpty lat then []
        elif List.hd lat = old then _new :: inner (List.tl lat)
        else List.hd lat :: inner (List.tl lat)
    inner list

let expected = ["chocolate"; "ice"; "cream"]
let actual = replace "chocolate" "vanilla" ["vanilla"; "ice"; "cream"]
assert (expected = actual)
;;