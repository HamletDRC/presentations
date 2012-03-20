import groovy.transform.TypeChecked


@TypeChecked
def method() {
    
    def map = [x: 1, y: 2, z: 3]
    
    assert map*.key == ['x', 'y', 'z']
    assert map*.value == [1, 2, 3]
    
    assert map*.key*.toUpperCase() == ['X', 'Y', 'Z']

    //assert map*.value*.toUpperCase() == ['X', 'Y', 'Z']
}
