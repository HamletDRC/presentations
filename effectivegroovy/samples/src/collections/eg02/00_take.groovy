package collections.eg02


def list = [1, 2, 3]

assert list[0..2] == [1, 2, 3]

try {
    assert list[0..3] == [1, 2, 3]

} catch (IndexOutOfBoundsException e) {}


assert list.take(3) == [1, 2, 3]

assert list.take(4) == [1, 2, 3]

println 'success'