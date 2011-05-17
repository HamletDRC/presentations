package gpp

// unoptimized recursion
def reverse
reverse = { input, accumulatedResult = '' ->
    if (input.size() < 2) { accumulatedResult + input }
    else { reverse(input[0..-2], accumulatedResult + input[-1]) }
}
println reverse("hello world" * 1000)


@Typed
class StringUtils {
    static reverse(String input, String accumulatedResult = '') {
        if (input.size() < 2) { accumulatedResult + input }
        else { reverse(input[0..-2], accumulatedResult + input[-1]) }
    }
}
println StringUtils.reverse('hello world' * 1000)







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