import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters
import spock.lang.Specification
import spock.lang.Unroll

class TableTest extends Specification {

    @Unroll("maximum of #a and #b is #c")
    def "maximum of two numbers"() {
        expect:
        Math.max(a, b) == c

        where:
        a | b | c
        3 | 7 | 7
        5 | 4 | 5
        9 | 9 | 9
    }


    class HelloSpock extends spock.lang.Specification {
        def "length of Spock and friends"() {
            expect:
            name.length() == length

            where:
            name | length
            "Spock" | 5
            "Kirk" | 4
            "Scotty" | 6
        }
    }
}