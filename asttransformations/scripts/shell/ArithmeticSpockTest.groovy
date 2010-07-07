import spock.lang.Specification
import spock.lang.Unroll

class ArithmeticSpockTest extends Specification {

    def "Does simple math work?"() {
        expect:
        new ArithmeticShell().evaluate(input) == output

        where:
        input                           | output
        '++(5)'                         | 6
        '5 < 4 ? 1 : 0'                 | 0
        '5 != 4 ? 0 : 1'                | 0
        '5 < 4 ?: 0 '                   | 0
        '((6L / 2f) - 1) ** 4.5e2'      | 2.9073548971824276E135
        '10 * Math.sin(15/-20)'         | -6.816387600233341
        'Math.cos(2*Math.PI)'           | 1.0
        '80*Math.E**(-(+(11++/40)**2))' | 74.17310622494026
        'Integer.MAX_VALUE - ++2%2'     | 2147483646
        '2*PI'                          | 6.283185307179586
        'cos(1)'                        | 0.5403023058681398
        'cos(2*PI)'                     | 1.0
    }

    def "Does security sandbox work? "() {
        
        when:
        new ArithmeticShell().evaluate(input)

        then:
        thrown(SecurityException)

        where:
        input << [ 'Double.valueOf("5")',
                   'import java.text.DateFormat; 5',
                   'import static java.lang.System.*; 6 * out',
                   'def x = 5+3;x.toString()',
                   'new File();Double.valueOf("5")' ]
    }















    def "if statement should work"() {
        expect:
        new ArithmeticShell().evaluate(input) == output

        where:
        input                               | output
        "if (true) return 5 else return 0"  | 5
    }
}
