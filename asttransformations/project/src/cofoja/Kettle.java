package cofoja;

import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;

class Kettle {

    int waterVolume = 0;
    int maxVolume = 1000;

    void addWater(int amount) {
        waterVolume = Math.min(maxVolume, amount + waterVolume);
    }

    int pour(int desiredAmount) {
        int amountPoured = (desiredAmount <= waterVolume
                ? desiredAmount
                : waterVolume);
        waterVolume = waterVolume - amountPoured;
        return amountPoured;
    }
}
