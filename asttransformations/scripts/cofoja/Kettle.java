
import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;

@Invariant( {
    " waterVolume >= 0", 
    " waterVolume <= maxVolume " })
class Kettle {
    
    int waterVolume = 0; 
    int maxVolume = 1000; 
    
    @Requires(" amount > 0 ")
    @Ensures(" waterVolume == maxVolume || waterVolume > old(waterVolume) ") 
    void addWater(int amount) {
        waterVolume = Math.min(maxVolume, amount + waterVolume); 
    }

    @Requires(" desiredAmount > 0 ") 
    @Ensures({   
            "result >= 0 ", 
            "(result == 0 " + 
                " ? waterVolume == old(waterVolume) " +
                " : waterVolume < old(waterVolume)) " 
        }) 
    int pour(int desiredAmount) {
        int amountPoured = (desiredAmount <= waterVolume 
                ? desiredAmount 
                : waterVolume); 
        waterVolume = waterVolume - amountPoured; 
        return amountPoured; 
    }


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

