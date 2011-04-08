package bpm._01;


public class MyBusinessObject {

    public void save() {
        
        runValidationQuery();
        performPartialSave();
        runValidationQuery2();
        finishSave();
    }

    private void runValidationQuery() {
        throw new UnsupportedOperationException("todo: implements");
    }

    private void performPartialSave() {
        throw new UnsupportedOperationException("todo: implements");
    }

    private void runValidationQuery2() {
        throw new UnsupportedOperationException("todo: implements");
    }

    private void finishSave() {
        throw new UnsupportedOperationException("todo: implements");
    }
}
