package eg04

import java.util.concurrent.locks.ReentrantReadWriteLock

class MyDataStore5 {
    def map = [:]
    final lock = new ReentrantReadWriteLock()
    
    def add(key, value) {
        lock.writeLock().lock()
        try {
            map.put(key, value)
        } finally {
            lock.writeLock().unlock()
        }
    }

    def getAt(key) {
        lock.readLock().lock()
        try {
            map[key]
        } finally {
            lock.readLock().unlock()
        }
    }
}


def store = new MyDataStore5()

store.add(1, 'one')
store.add(2, 'two')

assert store[1] == 'one'