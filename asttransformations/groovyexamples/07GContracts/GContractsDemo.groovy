package gcontracts

import org.gcontracts.annotations.*

class Ariane5 {

    long speed = 0
    boolean engineStarted = false

    @Requires({ increase > 0 && engineStarted == true })
    @Ensures({ old.speed < speed })
    void accelerate(increase) {
        speed += increase
    }

    @Requires({ engineStarted == false })
    @Ensures( { engineStarted == true } )
    void startEngine() {
        engineStarted = true
    }
}
