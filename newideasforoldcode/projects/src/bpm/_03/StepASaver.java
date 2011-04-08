package bpm._03;

/**
* @author Hamlet D'Arcy
*/
class StepASaver implements Saver {
    @Override
    public void invoke() {
        runValidationQuery();
    }

    private void runValidationQuery() {
        // run the other validation process
    }
}
