package eg04_synchronization


class MyDataStore {
    def map = [:]

    def add(key, value) {
        map.put(key, value)
    }

    def getAt(key) {
        map[key]
    }
}


def store = new MyDataStore()

store.add(1, 'one')
store.add(2, 'two')

assert store[1] == 'one'