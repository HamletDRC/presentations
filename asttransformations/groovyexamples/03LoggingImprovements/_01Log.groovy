@groovy.util.logging.Log
class Person {
    def method() {
        log.fine(runLongDatabaseQuery())
    }
}

new Person().method()

println "Success"