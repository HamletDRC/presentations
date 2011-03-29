package inspections;

public class _04Example {
    private static final boolean DEFAULT = true;

    void myMethod(Boolean value) {
        if (value == null)
            System.out.println("value: null");
            value = DEFAULT;

        System.out.println("received: " + value);
    }
}
