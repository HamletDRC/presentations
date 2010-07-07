
import spock.lang.Specification

class MathSpec extends Specification {

    def "Does simple math work?"() {
        expect:
        
        new GroovyShell().evaluate(input) == output

        where:
        input       | output
        '1 + 1'     | 2
        '2 + 2'     | 4
        '1.4 + 1.4' | 2.8
    }
}
