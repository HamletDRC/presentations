
import groovy.transform.*

@AutoClone(style=AutoCloneStyle.COPY_CONSTRUCTOR)
class Person {
    String firstName, lastName
    Date birthday
}

