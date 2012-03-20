package groovy2

import groovy.transform.TypeChecked

@TypeChecked
void method(def message) {
    if (message instanceof String) {
        println("Received input: ${message.toUpperCase()}")
    }
}
