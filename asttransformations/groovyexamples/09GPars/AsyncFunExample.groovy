
import groovyx.gpars.*

import groovyx.gpars.*

class MyClass {
    @AsyncFun
    def doubler = { it ->
        println("Doubling $it on thread ${Thread.currentThread().name}")
        it * 2
    }
}

GParsPool.withPool(5) {service ->
    def x = new MyClass()
    (1..5).each {
        x.doubler(it)
    }
}
