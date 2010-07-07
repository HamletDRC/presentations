
import org.gcontracts.annotations.Ensures
import org.gcontracts.annotations.Invariant
import org.gcontracts.annotations.Requires

@Invariant({ speed >= 0 })
class Ariane5 {

    long speed = 0
    boolean engineStarted

    @Requires({ engineStarted && increase > 0 })
    @Ensures({ old -> old.speed < speed })
    void accelerate(increase) {
        speed += increase
    }

    @Requires({ !engineStarted })
    @Ensures({ engineStarted })
    void startEngine() {
        engineStarted = true
    }
}


