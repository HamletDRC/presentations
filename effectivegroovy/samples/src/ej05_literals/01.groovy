package ej05_literals

def s = new String('abc')
def i = new Integer(5)
def b = new Boolean(true)













assert 12345G   instanceof BigInteger
assert 123.45G  instanceof BigDecimal

assert  []                  instanceof ArrayList
assert  [:]                 instanceof HashMap
assert  ([] as Set)         instanceof HashSet
assert  ([] as Stack)       instanceof Stack

CaseInsensitiveList list = [] as CaseInsensitiveList
assert  list instanceof CaseInsensitiveList










def isBabyBoomer = { birthDate ->
    Calendar cal = Calendar.getInstance()
    cal.set(1946, 0, 1, 0, 0, 0)
    Date boomStart = cal.getTime()
    cal.set(1965, 0, 1, 0, 0, 0)
    Date boomEnd = cal.getTime()
    boomStart.before(birthDate) && boomEnd.after(birthDate)
}
println isBabyBoomer(new Date()) // now








def myList = [] as CaseInsensitiveList
myList << 'ELEMENT'
assert myList.contains('element')


class CaseInsensitiveList extends ArrayList<String> {
    def CaseInsensitiveList() {
    }

    def CaseInsensitiveList(Collection<? extends String> c) {
        super(c.collect { String it -> it.toLowerCase() } )
    }

    @Override
    boolean contains(Object o) {
        super.contains(o instanceof String ? o.toLowerCase() : o)
    }

    @Override
    int indexOf(Object o) {
        super.indexOf(o instanceof String ? o.toLowerCase() : o)
    }

    @Override
    int lastIndexOf(Object o) {
        super.lastIndexOf(o instanceof String ? o.toLowerCase() : o)
    }

    @Override
    String set(int index, String element) {
        super.set(index, element.toLowerCase())
    }

    @Override
    boolean add(String e) {
        super.add(e.toLowerCase())
    }

    @Override
    void add(int index, String element) {
        super.add(index, element.toLowerCase())
    }

    @Override
    boolean remove(Object o) {
        super.remove(o instanceof String ? o.toLowerCase() : o)
    }

    @Override
    boolean addAll(Collection<? extends String> c) {
        super.addAll(c.collect { it.toLowerCase() })
    }

    @Override
    boolean addAll(int index, Collection<? extends String> c) {
        super.addAll(index, c.collect { it.toLowerCase() } )
    }

    @Override
    boolean removeAll(Collection<?> c) {
        super.removeAll(c.collect { it.toLowerCase() })
    }

    @Override
    boolean retainAll(Collection<?> c) {
        super.retainAll(c.collect {it.toLowerCase()})
    }
}