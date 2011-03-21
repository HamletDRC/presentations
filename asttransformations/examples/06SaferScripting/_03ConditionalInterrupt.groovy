
@ConditionalInterrupt({ errorCount >= 10})
import groovy.transform.ConditionalInterrupt

errorCount = 0

1000.times {
    try {
         println 'working...'
         throw new RuntimeException()
    } catch (Throwable t) {
        errorCount++
    }
}


