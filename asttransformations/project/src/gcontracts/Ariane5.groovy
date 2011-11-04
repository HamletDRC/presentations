package gcontracts

import org.gcontracts.annotations.Ensures
import org.gcontracts.annotations.Requires
import org.gcontracts.annotations.Invariant


@Invariant({ speed >= 0 })
class Ariane5 {

    long speed = 0
    boolean engineStarted = false

    @Requires({ engineStarted == false })
    @Ensures( { engineStarted == true } )
    void startEngine() {
        engineStarted = true
    }

    @Requires({ increase > 0 && engineStarted == true })
    @Ensures({ old.speed < speed })
    void accelerate(increase) {
        speed += increase
    }
}

