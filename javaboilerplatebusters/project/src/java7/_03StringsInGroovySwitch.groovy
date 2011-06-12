package java7


Number apply(int left, String operator, int right) {

    switch (operator) {
        case ~/(?i)plus/: return left + right
        case ~/(?i)minus/: return left - right
        case ~/(?i)times/: return left * right
        case ~/(?i)divided by/: return left / right
        default: throw new Exception(operator)
    }
}

assert apply(1, 'plus', 2) == 3
assert apply(1, 'PLUS', 2) == 3
assert apply(5, 'times', 2) == 10
assert apply(5, 'minus', 2) == 3

println 'Success'