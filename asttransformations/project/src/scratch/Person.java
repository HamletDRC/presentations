package scratch;

public class Person {

  private String firstName;
  private String lastName;

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String paramString) {
    this.firstName = paramString;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String paramString) {
    this.lastName = paramString;
  }

  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true;
    if (paramObject == null)
      return false;
    if (paramObject.getClass() != getClass())
      return false;
    Person localPerson = (Person) paramObject;
    if (this.firstName == null ? localPerson.firstName != null : !this.firstName.equals(localPerson.firstName))
      return false;
    return this.lastName == null ? localPerson.lastName == null : this.lastName.equals(localPerson.lastName);
  }

  public int hashCode() {
    int i = 1;
    i = i * 31 + (this.firstName == null ? 0 : this.firstName.hashCode());
    i = i * 31 + (this.lastName == null ? 0 : this.lastName.hashCode());
    return i;
  }

  public String toString() {
    return "Person(firstName=" + this.firstName + ", lastName=" + this.lastName + ")";
  }
}