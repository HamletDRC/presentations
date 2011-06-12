package closures

// ok
[1,2,3].each({ println it })

// better
[1,2,3].each() { println it }

// best
[1,2,3].each { println it }

