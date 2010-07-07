package gcontracts


def rocket = new Ariane5()

shouldFail {
    rocket.accelerate 5  // rocket not started!
}

rocket.startEngine()

shouldFail {
    rocket.startEngine()
}

rocket.accelerate 5

assert rocket.speed == 5

rocket.accelerate 10

assert rocket.speed == 15

shouldFail {
    rocket.accelerate -10
}

shouldFail {
    rocket.accelerate Long.MAX_VALUE
}


def shouldFail(f) {
    try {
        f()
    } catch (Throwable t) {
        // do nothing
        return
    }
    throw new AssertionError()
}