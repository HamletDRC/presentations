package eg04

import java.util.concurrent.locks.ReentrantReadWriteLock

class MyDataStore6 {
    def map = [:]
    final lock = new ReentrantReadWriteLock()
    
    def add(key, value) {
        withWriteLock(lock) {
            map.put(key, value)
        }
    }

    def getAt(key) {
        withReadLock(lock) {
            map[key]
        }
    }

    def static withWriteLock(ReentrantReadWriteLock lock, Closure f) {
        lock.writeLock().lock()
        try {
            f()
        } finally {
            lock.writeLock().unlock()
        }
    }

    def static withReadLock(ReentrantReadWriteLock lock, Closure f) {
        lock.readLock().lock()
        try {
            f()
        } finally {
            lock.readLock().unlock()
        }
    }
}


def store = new MyDataStore6()

store.add(1, 'one')
store.add(2, 'two')

assert store[1] == 'one'