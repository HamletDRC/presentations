package cmdexprs

import groovy.transform.TupleConstructor

enum Location {
    busstop, Basel, tramstop, Birsfelden
}


enum Vehicle {
    bus, tram
}


@TupleConstructor
class Duration {
    int value
    String unit

    String toString() {
        "$value $unit"
    }
}

@TupleConstructor
class Instruction {
    String action
    Location location
    Duration duration
    Vehicle vehicle

    @Override
    String toString() {
        if (vehicle != null) {
            "$action $duration on $vehicle towards $location"
        } else {
            "$action $duration at $location"
        }
    }
}
