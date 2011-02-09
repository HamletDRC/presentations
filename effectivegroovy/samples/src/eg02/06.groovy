package eg02

import groovy.transform.Field


int fib(int seed) {
    if (seed == 0) return seed;
    if (seed == 1) return seed;
    return fib(seed - 2) + fib(seed - 1); 
}

println fib(43)


@Field Map<Integer, Integer> cache = new HashMap<Integer, Integer>()
int fib2(int seed) {
    if (seed == 0) return seed
    if (seed == 1) return seed
    int minus2 = cache.get(seed - 2) ?: fib2(seed - 2)
    int minus1 = cache.get(seed - 1) ?: fib2(seed - 1)
    cache.put(seed-2, minus2)
    cache.put(seed-1, minus1)
    minus2 + minus1
}

println fib2(43)

def fib3
fib3 = { seed ->
    if (seed == 0) return seed;
    if (seed == 1) return seed;
    fib3(seed - 2) + fib3(seed - 1)
}.memoize()

println fib3(43)
