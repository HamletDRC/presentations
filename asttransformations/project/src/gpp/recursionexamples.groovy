package gpp


@Typed
class Calculator {
    def factorial(BigInteger seed, BigInteger acc = 1) {
        if (seed <= 1) return acc
        factorial(seed - 1, acc * seed)
    }

    def mapManipulation(BigInteger seed, Map<String, BigInteger> acc = [result:1G, iteration: 0G]) {

        if (seed <= 1) {
            return acc
        }
        acc.result = acc.result * seed
        acc.iteration = acc.iteration + 1
        mapManipulation(seed - 1, acc)
    }

}

println new Calculator().mapManipulation(5000G)
println new Calculator().factorial(5000G)

def factorial(BigInteger seed, BigInteger acc = 1) {
    if (seed <= 1) return acc
    factorial(seed - 1, acc * seed)
}

println factorial(5000G)
