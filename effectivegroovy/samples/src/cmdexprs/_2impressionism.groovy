package cmdexprs

Integer.metaClass.getMinute  = { new Duration(delegate, 'minute') }
Integer.metaClass.getMinutes = { new Duration(delegate, 'minutes') }
Integer.metaClass.getStop    = { new Duration(delegate, 'stop') }
Integer.metaClass.getStops   = { new Duration(delegate, 'stops') }

import static cmdexprs.Location.*
import static cmdexprs.Vehicle.*

instructions = []

def stand(Duration duration) {
    [at: { Location location ->
        instructions << new Instruction('stand', location, duration)
    }]
}

def ride(Duration duration) {
    [on: { Vehicle vehicle ->
        [towards: { Location location ->
            instructions << new Instruction('ride', location, duration, vehicle)
        }]
    }]
}

stand(7.minutes).at(busstop)
ride(10.stops).on(bus).towards(Basel)
stand(5.minutes).at(tramstop)
ride(3.stops).on(tram).towards(Birsfelden)

println instructions.join('\n')



