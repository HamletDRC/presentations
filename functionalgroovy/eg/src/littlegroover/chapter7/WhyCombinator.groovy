package littlegroover.chapter7

/*
@author Hamlet D'Arcy

File under uselessly cool (for now at least).

A Y-Combinator in Groovy! 
*/

def Y = { le -> { f -> f(f) }({ f -> le { x -> f(f)(x) } }) }

/*
And to prove it works, you can define a recursive factorial function without using recursion in the language. 
 */
def factorial = Y { fac ->
    { n -> n <= 2 ? n : n * fac(n - 1) }
}

assert 2432902008176640000 == factorial(20G)
/*
The one-liner closure in the middle is the meat of the method definition and is a
classic (i.e. horribly inefficient, known deficient) factorial implementation.
I wouldn't write code this way but it makes a nice terse example when written in one line.

So is this useless? Not at all! But getting to an explanation of its use requires just
a few examples.

Consider a recursive function that determines if an element is a member of a list.
I guess you should also consider that List#contains(Object) does not exist.
Here is a first draft of such function:
 */
def isMember(element, list) {
    if (!list) false
    else
        if (list.head() == element) true
        else isMember(element, list.tail())
}

assert isMember(2, [1, 2, 3])
/*
Let's just step through it briefly.
    if (!list) false - a simple terminating condition, an empty list never contains the element
    if (list.head() == element) true - if the first item in the list is the element then yes, we found it!
    else isMember(element, list.tail()) - otherwise, check all the other items in the list for the same condition
Over time, the isMember will be recursively applied to each element in the list, and call stacks will build up
in memory until the element is found, the list is fully checked, or you run out of stack space.

The problem with isMember is the redundancy. Notice how 'element' is always passed as a parameter? The value never
changes over the life of the function application, so we shouldn't bother passing it every time. We have closures,
so why don't we just 'close over' the value of element and remove the redundant data passing?

We can do it, but because of Groovy's limited recursion support, the implementation is kinda ugly. What I'd like
to do is create a recursive closure that captures element once, but Groovy forces me into declaring an inner looping
function on one line and defining it on another:
 */
def isMember2(element, list) {
    def inner
    inner = { lat ->
        if (!lat) false
        else
            if (lat.head() == element) true
            else inner(lat.tail())
    }
    inner(list)
}

assert isMember2(2, [1, 2, 3])
/*
This is where Y comes into play. I want a recursive closure and that is what Y does! Check out how Y allows me to
define a recursive function locally within a method. No more split on declaration/definition. 
 */
def isMember3 = {element, list->
    def inner = Y { inner ->
        { lat ->
            if (!lat) false
            else
                if (lat.head() == element) true
                else inner(lat.tail())
        }
    }
    inner(list)
}

assert isMember3(2, [1, 2, 3])

/*
It's not uselessly cool any more is it? Oh wait, without tail call optimization on the JVM you will
certainly run out of stack space by writing code like this. So don't do it!

I guess it's pretty useless after all.

And if you're looking for a fun weekend project, why don't you do a different one of the Rosetta Code challenges
that are missing for Groovy: http://rosettacode.org/wiki/Tasks_not_implemented_in_Groovy

Tschüs!

*/