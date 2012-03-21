package inspections;

public class Example01 {

    {
        try {
            doSomething();
        } catch (UnsupportedOperationException e) {
            handleError(e);
        } catch (IllegalStateException e) {
            handleError(e);
        } catch (IllegalArgumentException e) {
            handleError(e);
        }
    }








    void handleError(Exception e) {
        e.printStackTrace(System.err);
        System.err.println(e.getMessage());
    }

    private void doSomething() {
        // ... do something
    }
}
