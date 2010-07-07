

let rec remove a lat =
    if List.isEmpty lat then []
    elif List.hd lat = a then List.tl lat
    else List.hd lat :: (remove a (List.tl lat)) 


assert (["apples"; "oranges"] = remove "berries" ["apples"; "oranges"; "berries"])
assert (["butter"; "jelly"] = remove "peanut" ["peanut"; "butter"; "jelly"])

let rec evens lat =
    if List.isEmpty lat then []
    elif List.hd lat % 2 = 0 then evens (List.tl lat)
    else List.hd lat :: evens (List.tl lat) 


assert ([2; 4; 6] = evens [1; 2; 3; 4; 5; 6])

;;
