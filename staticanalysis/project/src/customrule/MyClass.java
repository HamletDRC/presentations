package customrule;


public class MyClass {

    void print(Object value) {
        if (value != null && value instanceof String) {
            System.out.println(value);
        }
    }
}
