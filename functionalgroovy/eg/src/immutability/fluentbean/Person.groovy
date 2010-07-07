package immutability.fluentbean

class Person {

  def firstName
  def lastName

  def setFirstName(firstName) {
    this.firstName = firstName
    this
  }

  def setLastName(lastName) {
    this.lastName = lastName
    this
  }
}
