package dupes;

public class ClassWithDuplicates {

    void print(String message) {
        if (message != null && !message.isEmpty()) {
            System.out.println(message);
        }
    }

    void log(String value) {
        if (value != null && !value.isEmpty()) {
            System.out.println(value);
        }
    }
}
