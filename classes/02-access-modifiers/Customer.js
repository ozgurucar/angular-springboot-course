"use strict";
class CustomerB {
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
let myCustomerB = new CustomerB("John", "Doe");
myCustomerB.firstName = "Greggu";
console.log(myCustomerB.firstName);
console.log(myCustomerB.lastName);
