class Person {
  private final phoneNumbers = [:]

    @groovy.transform.WithReadLock
    def getPhoneNumber(key) {
        phoneNumbers[key]
    }
    @groovy.transform.WithWriteLock
    def addPhoneNumber(key, value) {
        phoneNumbers[key] = value
    }
}


