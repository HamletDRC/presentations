

let size a = String.length a

// remember insertL? How about an insertL along with a count function?

let rec removeAndCount a lat = 
    if List.isEmpty lat then [] 
    elif List.hd lat = a then removeAndCount a lat 
    else 
        (List.hd lat, size (List.hd lat)) :: removeAndCount a (List.tl lat)

assert ([("apples", 6); ("oranges", 7)] = removeAndCount "berries" ["apples"; "oranges"; "berries"])


let removeAndCount2 a list =
    let rec inner lat =  
        if List.isEmpty lat then [] 
        elif List.hd lat = a then removeAndCount a lat 
        else 
            (List.hd lat, size (List.hd lat)) :: inner (List.tl lat)
    inner list 

assert ([("apples", 6); ("oranges", 7)] = removeAndCount2 "berries" ["apples"; "oranges"; "berries"])


let removeAndCount3 a list =
    let rec inner lat =  
        match lat with 
        | [] -> []
        | head :: tail when head = a -> inner tail
        | head :: tail -> (head, size head) :: inner tail
    inner list 

assert ([("apples", 6); ("oranges", 7)] = removeAndCount3 "berries" ["apples"; "oranges"; "berries"])
;;