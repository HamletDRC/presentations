package ej41

import groovy.util.logging.Log

@Log class OldCalculator {

    def log(methodName, parm1, parm2) {
        log.info(
                "Method Called: $methodName" +
                        (parm1 ? ", p1: $parm1" : '') +
                        (parm2 ? ", p2: $parm2" : '')
        )
    }

    def log(methodName, parm1) {
        log(methodName, parm1, null)
    }

    def log(methodName) {
        log(methodName, null, null)
    }

    def add(x, y) {
        log('add', x, y); x+y
    }

    def increment(x) {
        log('increment', x); x++
    }
}


new OldCalculator().add(1, 3)
new OldCalculator().increment(2)


@Log class Calculator {

    def log(String methodName, Object parm1 = null, Object parm2 = null) {
        log.info(
                "Method Called: $methodName" +
                        (parm1 ? ", p1: $parm1" : '') +
                        (parm2 ? ", p2: $parm2" : '')
        )
    }

    def add(x, y) {
        log('add', x, y)
        x+y
    }

    def increment(x) {
        log('increment', x)
    }
}

new Calculator().add(1, 3)
new Calculator().increment(2)