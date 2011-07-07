package ej41_overloading

import groovy.util.logging.Log

@Log class OldLogFacade {

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
}

OldLogFacade facade = new OldLogFacade()
facade.log('add', 1, 3)
facade.log('increment', 2)


@Log class LogFacade {

    def log(String methodName, Object parm1 = null, Object parm2 = null) {
        log.info(
                "Method Called: $methodName" +
                        (parm1 ? ", p1: $parm1" : '') +
                        (parm2 ? ", p2: $parm2" : '')
        )
    }
}

LogFacade facade2 = new LogFacade()
facade2.log('add', 1, 3)
facade2.log('increment', 2)
