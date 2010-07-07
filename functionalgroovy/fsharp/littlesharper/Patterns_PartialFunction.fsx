

let rec remove a lat =
    match lat with 
    | [] -> []
    | head :: tail when head = a -> List.tl lat
    | head :: tail -> head :: remove a tail


assert (["apples"; "oranges"] = remove "berries" ["apples"; "oranges"; "berries"])
assert (["butter"; "jelly"] = remove "peanut" ["peanut"; "butter"; "jelly"])

let removeApples = remove "apples"

assert (["apples"; "oranges"] = removeApples ["apples"; "oranges"; "berries"])

;;