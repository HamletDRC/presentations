package backnotout



def getEvenNumbers(int bottom, int top) {
    def elements = (bottom..top).findAll {
        it % 2 == 0
    }
    return [elements, elements.size()]
}

def (elements, x) = getEvenNumbers(5, 15)

println elements
println x
