package bpm._02;


public class MyBusinessObject {

    public void save() {

        runValidationQuery();
        performPartialSave();
        runValidationQuery2();
        finishSave();
    }

    private void performPartialSave() {
        // do some bits of saving
    }

    private void runValidationQuery2() {
        // run a validation query
    }

    private void finishSave() {
        // finish the saving process
    }

    private void runValidationQuery() {
        // run the other validation process
    }

}
