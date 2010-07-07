package immutability

import spock.lang.Sputnik
import org.junit.runner.RunWith
import spock.lang.Speck


@Speck
@RunWith(Sputnik)
class ListTest {

    def "lists are inherently mutable"() {

        when:
        def a = [1, 2, 3]
        def b = a << 4

        then:
        assert b == [1, 2, 3, 4]
        assert a.is(b)
    }
}
