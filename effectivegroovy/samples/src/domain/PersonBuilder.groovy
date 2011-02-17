package domain

/**
 * 
 * @author Hamlet D'Arcy
 */
public static class PersonBuilder {
    private String firstName
    private String lastName
    private Integer id

    public PersonBuilder withID(int id) {
        this.id = id;
        return this;
    }

    public PersonBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PersonBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Person build() {
        return new Person(id, firstName, lastName);
    }
}
