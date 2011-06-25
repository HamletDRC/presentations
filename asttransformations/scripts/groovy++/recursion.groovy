@Grab('org.mbte.groovypp:groovypp-all:0.4.248_1.8.0')
@Grab('org.mbte.groovypp:groovypp:0.4.248_1.8.0')
@Typed
class StringUtils {
    static reverse(String input, String accumulatedResult = '') {
        if (input.size() < 2) { accumulatedResult + input }
        else { reverse(input[0..-2], accumulatedResult + input[-1]) }
    }
}
println StringUtils.reverse('hello world')

