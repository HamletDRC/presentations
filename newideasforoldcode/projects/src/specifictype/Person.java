package specifictype;



public class Person {

    boolean validateAddress(Person p) { return true; }
    boolean validateAddress(Address a) { return true; }
    boolean validateAddress(String a) { return true; }

    private static class Address {

    }
}


