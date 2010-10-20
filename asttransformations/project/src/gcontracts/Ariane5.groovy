package gcontracts

import org.gcontracts.annotations.Ensures
import org.gcontracts.annotations.Invariant
import org.gcontracts.annotations.Requires

class Ariane5 {

    long speed = 0
    boolean engineStarted

    void accelerate(increase) {
        speed += increase
    }

    void startEngine() {
        engineStarted = true
    }
}

