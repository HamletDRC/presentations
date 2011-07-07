package eg04_synchronization


class MyDataStore3 {
    def map = [:]
    private final lock = new Object()

    def add(key, value) {
        synchronized(lock) {
            map.put(key, value)
        }
    }

    def getAt(key) {
        synchronized(lock) {
            map[key]
        }
    }
}


def store = new MyDataStore3()

store.add(1, 'one')
store.add(2, 'two')

assert store[1] == 'one'