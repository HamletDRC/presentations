package eg04

import groovy.transform.Synchronized


class MyDataStore4 {
    def map = [:]

    @Synchronized
    def add(key, value) {
        map.put(key, value)
    }

    @Synchronized
    def getAt(key) {
        map[key]
    }
}


def store = new MyDataStore4()

store.add(1, 'one')
store.add(2, 'two')

assert store[1] == 'one'