package eg06_defaultparms

import groovy.util.logging.Log

@Log
class MyClass {

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

new MyClass().add(1, 3)
new MyClass().increment(2)
