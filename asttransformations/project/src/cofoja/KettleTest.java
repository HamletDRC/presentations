package cofoja;


public class KettleTest {

    public static void main(String[] args) {
        Kettle kettle = new Kettle();

        kettle.addWater(750);
        assert kettle.waterVolume == 750;

        kettle.addWater(750);
        assert kettle.waterVolume == 1000;

        try {
            kettle.addWater(-500);
            throw new AssertionError("... should never happen");
        } catch (com.google.java.contract.PreconditionError e) {
            assert kettle.waterVolume == 1000;
        }

        assert kettle.pour(1500) == 1000;   // only pours what it has
        assert kettle.waterVolume == 0;

        System.out.println("Success");
    }

}
