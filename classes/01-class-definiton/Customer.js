"use strict";
class Customer {
    constructor(theFirst, theLast) {
        this._firstName = theFirst;
        this._lastName = theLast;
    }
    get firstName() {
        return this._firstName;
    }
    get lastName() {
        return this._lastName;
    }
    set firstName(theFirst) {
        this._firstName = theFirst;
    }
    set lastName(theLast) {
        this._lastName = theLast;
    }
}
let myCustomer = new Customer("John", "Doe");
myCustomer.firstName = "Greg";
console.log(myCustomer.firstName);
console.log(myCustomer.lastName);
