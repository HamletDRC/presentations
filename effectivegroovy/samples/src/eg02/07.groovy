package eg02

int factorial(int seed) {
    if (seed == 1) return 1;
    return seed * factorial(seed -1);
}

println factorial(25)

def factorial2
factorial2 = { BigInteger seed ->
    if (seed == 1) return 1;
    return seed * factorial2(seed -1);
}

println factorial2(200)


def fact
fact = {int n, BigInteger accumulator ->
    n > 1 ? fact.trampoline(n - 1, n * accumulator) : accumulator
}.trampoline()

def factorial3 = {int n -> fact(n, 1 as BigInteger)}

println factorial3(1000)
