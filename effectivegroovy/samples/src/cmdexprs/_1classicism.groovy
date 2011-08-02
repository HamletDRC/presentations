package cmdexprs


import static cmdexprs.Location.*
import static cmdexprs.Vehicle.*

instructions = []

def minutes(int length) {
    new Duration(length, 'minutes')
}

def stand(Duration duration) {
    [at: { Location location ->
        instructions << new Instruction('stand', location, duration)
    }]
}

def ride(Duration duration) {
    [ on: { Vehicle vehicle ->
        [towards: { Location location ->
            instructions << new Instruction('ride', location, duration, vehicle)
        }]
    } ]
}

stand(minutes(5)).at(busstop)
ride(minutes(10)).on(bus).towards(Basel)

println instructions.join('\n')

