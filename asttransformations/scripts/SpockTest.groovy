package example

//import org.junit.runner.RunWith
//import spock.lang.*

def "maximum of two numbers"() {
  expect:
  Math.max(a, b) == c

  where:
  a | b | c
  3 | 7 | 7
  5 | 4 | 5
  9 | 9 | 9
}

