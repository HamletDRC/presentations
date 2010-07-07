// define math operators in relation to to primitives
let add1 n = n + 1
let sub1 n = n - 1

let rec plus n m = 
    if m = 0 then n
    else plus (add1 n) (m-1)


assert (2 = plus 1 1)
assert (4 = plus 2 2)

let rec minus n m =
    if m = 0 then n
    else minus (sub1 n) (m-1)

assert (0 = minus 1 1)
assert (5 = minus 10 5)

let rec multiply n m = 
    if m = 0 then 0
    else
        plus n (multiply n (sub1 m))

assert (6 = multiply 3 2)
assert (12 = multiply 4 3)

;;
