package bpm._03;


public class MyBusinessObject {

    private StepASaver stepASaver = new StepASaver();
    private StepBSaver stepBSaver = new StepBSaver();
    private StepCSaver stepCSaver = new StepCSaver();
    private StepDSaver stepDSaver = new StepDSaver();

    public void save() {

        stepASaver.invoke();
        stepBSaver.invoke();
        stepCSaver.invoke();
        stepDSaver.invoke();
    }

    private class StepDSaver implements Saver {
        public void invoke() {
            finishSave();
        }

        private void finishSave() {
            // finish the saving process
        }
    }
}
