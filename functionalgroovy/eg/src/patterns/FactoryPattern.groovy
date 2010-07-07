package patterns


interface Calculation {
    def apply(n, m);
}

class CalculationFactory {
    def plus() { [apply: {n, m -> n + m } ] }
    def minus() { [apply: {n, m -> n - m } ] }
    def times() { [apply: {n, m -> n * m } ] }
    def divide() { [apply: {n, m -> n / m } ] }
}

assert 5 == new CalculationFactory().plus().apply(2, 3)

