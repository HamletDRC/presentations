class Person {
  private final phoneNumbers = [:]

    @groovy.transform.Synchronized
    def getPhoneNumber(key) {
        phoneNumbers[key]
    }
    @groovy.transform.Synchronized
    def addPhoneNumber(key, value) {
        phoneNumbers[key] = value
    }
}

