package domain


import groovy.transform.ToString

@ToString
class Address {

    def id, street, number
    
    static findAll() {[
            new Address(id: 1, street: 'Knox Ave', number: '5437'),
            new Address(id: 2, street: 'Mildmay Road', number: '81B'),
            new Address(id: 3, street: 'Gellertstrasse', number: '7')]}
}
