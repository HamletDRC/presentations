#light 

let calculate f n m = f n m 
let calcFactory f = calculate f    
let plus = calcFactory (+)
let minus = calcFactory (-)
let times = calcFactory (*)
let divide = calcFactory (/)

assert (5 = plus 2 3) 

;;