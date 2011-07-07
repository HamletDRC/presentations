package ej41_overloading

def function(Collection c) {
    println 'received collection'
}

def function(ArrayList a) {
    println 'received arraylist'
}

function((Collection) [])