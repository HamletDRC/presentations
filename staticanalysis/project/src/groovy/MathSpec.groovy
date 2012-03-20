package groovy

import spock.lang.Specification

class MathSpec extends Specification {

    def "test that addition works"() {

        expect:
        a + b == c

        where:
        a | b | c
        1 | 1 | 2
        2 | 2 | 4
        4 | 4 | 8

    }
}
