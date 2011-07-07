package eg04_synchronization

import groovy.transform.WithWriteLock
import groovy.transform.WithReadLock

class MyDataStore7 {
    def map = [:]

    @WithWriteLock
    def add(key, value) {
        map.put(key, value)
    }

    @WithReadLock
    def getAt(key) {
        map[key]
    }
}


def store = new MyDataStore7()

store.add(1, 'one')
store.add(2, 'two')

assert store[1] == 'one'