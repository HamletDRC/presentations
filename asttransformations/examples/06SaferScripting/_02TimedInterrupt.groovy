
@TimedInterrupt(1)
import groovy.transform.TimedInterrupt

1000.times {
    sleep(100)
    println new Date()
}


