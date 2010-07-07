package morphisms

import static littlegroover.Functions.cons

// catamorphism
def sum(list) {
    if (!list) 0
    else list.head() + sum(list.tail())
}

assert 10 == sum([1, 2, 3, 4])

// anamorphism
def first(max) {
    if (max == 1) [1]
    else cons(max, first(max-1))
}

assert [3, 2, 1] == first(3)

// hylomorphism
def sumFirst(max, list) {
    sum(first(max))
}
assert 10 == sumFirst(4, [1, 2, 3, 4, 5, 6, 7, 8, 9])

// metamorphism
def chars(string) {
    if (!string) []
    else if (string.length() == 1) [string]
    else cons(string[0], chars(string[1..string.length()-1]))
}

def concat(list) {
    if (!list) ""
    else list.head() + (concat(list.tail()))
}

assert ['C', 'a', 'k', 'e'] == chars('Cake')
assert "CakeAndPie" == concat(['Cake', 'And', 'Pie'])

def wordListToChars(list) {
    chars(concat(list))
}

assert ['a', 'b', 'c', 'd'] == wordListToChars(["ab", "cd"])