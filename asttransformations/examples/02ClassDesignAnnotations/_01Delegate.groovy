class Book {
    @Delegate Date releaseDate
}

def gina = new Book(releaseDate: new Date() - 7)
def regina = new Book(releaseDate: new Date() + 7)

assert gina.before(regina.releaseDate)
assert regina.after(gina.releaseDate)
assert (regina <=> gina.releaseDate == 1)