package eg04_synchronization


class MyDataStore2 {
    def map = [:]

    def synchronized add(key, value) {
        map.put(key, value)
    }

    def synchronized getAt(key) {
        map[key]
    }
}


def store = new MyDataStore2()

store.add(1, 'one')
store.add(2, 'two')

assert store[1] == 'one'