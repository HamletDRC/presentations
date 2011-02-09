package spock

import spock.lang.Specification
import spock.lang.Unroll

class MathSpec extends Specification {

    @Unroll
    def "Does simple math work?"() {

        expect:
        def s = new ArithmeticShell()
        s.evaluate(input) == output

        where:
        input       | output
        '1 + 1'     | 2
        '2 + 2'     | 4
        'cos(2*PI)' | 1.0
    }
}
