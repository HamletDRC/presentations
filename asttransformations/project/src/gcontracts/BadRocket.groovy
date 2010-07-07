package gcontracts


def rocket = new Ariane5()

// accelerate without starting engine ???
rocket.accelerate 5  

// start engine twice ???
rocket.startEngine()
rocket.startEngine()

rocket.accelerate 5
rocket.accelerate 10

// rockets have breaks ???
rocket.accelerate (-10)

// rockets wrap around to negative numbers ???
//rocket.accelerate Long.MAX_VALUE

