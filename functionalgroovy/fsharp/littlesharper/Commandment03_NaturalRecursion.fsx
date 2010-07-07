

let rec replace _new old lat = 
    if List.isEmpty lat then []
    elif List.hd lat = old then _new :: replace _new old (List.tl lat)
    else List.hd lat :: replace _new old (List.tl lat)

assert (["chocolate"; "ice"; "cream"] = replace "chocolate" "vanilla" ["vanilla"; "ice"; "cream"])

let rec insertL _new old lat = 
    if List.isEmpty lat then []
    elif List.hd lat = old then 
        _new :: (old :: (insertL _new old (List.tl(lat))))
    else
        List.hd lat :: insertL _new old (List.tl lat)

assert (["donuts"; "and"; "milk"] = insertL "and" "milk" (["donuts"; "milk"]))

let rec insertR _new old lat = 
    if List.isEmpty lat then []
    elif List.hd lat = old then
        old :: _new :: insertR _new old (List.tl lat)
    else
        List.hd lat :: insertR _new old (List.tl lat)

assert (["donuts"; "and"; "milk"] = insertR "and" "donuts" ["donuts"; "milk"])
;;