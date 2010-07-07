let rec plus n m = 
    if m = 0 then n 
    else plus (n+1) (m-1)
    
assert (1000 = plus 500 500)

;;
    
    