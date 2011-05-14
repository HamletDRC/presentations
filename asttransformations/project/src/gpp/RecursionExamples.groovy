package gpp

// unoptimized recursion
def reverse
reverse = { input, seed = '' ->
    if (!input) return seed
    if (input.size() == 1) return seed + input
    return reverse(input[0..-2], seed + input[-1])
}
println reverse("hello world")





// optimized tail recursion
@Typed
class Calculator {
    def factorial(BigInteger seed, BigInteger acc = 1) {
        if (seed <= 1) return acc
        factorial(seed - 1, acc * seed)
    }
}
println new Calculator().factorial(5000G)






// advanced optimized tail recursion
@Typed
class Calculator2 {

    def mapManipulation(BigInteger seed, Map<String, BigInteger> acc = [result:1G, iteration: 0G]) {

        if (seed <= 1) {
            return acc
        }
        acc.result = acc.result * seed
        acc.iteration = acc.iteration + 1
        mapManipulation(seed - 1, acc)
    }
}
println new Calculator2().mapManipulation(5000G)