package immutability

import immutability.builder.PersonBuilder



public class BeanTests extends GroovyTestCase {

    public void testSimpleGroovyBean() {
        def person = new immutability.bean.Person(firstName: 'hamlet', lastName: 'darcy')
        assert 'hamlet darcy' ==  "$person.firstName $person.lastName"
    }

    public void testSimpleJavaBean() {
        def person = new immutability.bean.Person()
        person.firstName = 'hamlet'
        person.lastName = 'darcy'
        assert 'hamlet darcy' ==  "$person.firstName $person.lastName"
    }

    public void testFluentBean() {
        def person = new immutability.fluentbean.Person()
            .setFirstName('hamlet')
            .setLastName('darcy')
        assert 'hamlet darcy' ==  "$person.firstName $person.lastName"
    }

    public void testBuilderPattern() {
        def person = new PersonBuilder()
                .setFirstName('hamlet')
                .setLastName('darcy')
                .build()
        assert 'hamlet darcy' ==  "$person.firstName $person.lastName"
    }

    public void testImmutableBean() {
        def person = new immutability.ibean.Person()
                .setFirstName('hamlet')
                .setLastName('darcy')
        assert 'hamlet darcy' ==  "$person.firstName $person.lastName"
    }

    public void testWithBlock() {
        def person = new immutability.bean.Person()
        person.with {
            firstName = 'hamlet'
            lastName = 'darcy'
        }
        assert 'hamlet darcy' ==  "$person.firstName $person.lastName"
    }

}