
let rec size lat = 
  if (List.isEmpty(lat)) then 0
  else 1 + size(List.tl(lat))


printfn ("asssert")

