package example

import groovy.mock.interceptor.MockFor
import java.awt.event.MouseListener



def mock = new MockFor(Service)
mock.demand.getFileSize { -10 }
mock.use {
    assert -10 == Service.getFileSize('file.txt')
}



// test cases and design document / requirements can look very similar

/*

Example:
Before:
Jane,Doe,25.00,4
After
Jane,Doe,100.00
*/

/*
def input = ['Jane','Doe',25.0,4]
def expected = ['Jane', 'Doe', 100.0]
def actual = transform(input)
asertTransformation(expected, input)

*/

boolean wasCalled = false
def listener = [ mouseEntered : { wasCalled = true } ] as MouseListener
listener.mouseEntered()
assert wasCalled