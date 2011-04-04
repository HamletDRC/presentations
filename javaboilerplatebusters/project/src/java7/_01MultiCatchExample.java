package java7;

import java.io.IOException;

/**
 * @author Hamlet D'Arcy
 */
public class _01MultiCatchExample {


    void oldStyle() {

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

    void newStyle() {
        
        try {
            doSomething();
        } catch (UnsupportedOperationException | IllegalStateException | IllegalArgumentException e) {
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
