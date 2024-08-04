"use strict";
class CustomerB {
    constructor(_firstName, _lastName) {
        this._firstName = _firstName;
        this._lastName = _lastName;
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
myCustomerB.firstName = "Gregga";
console.log(myCustomerB.firstName);
console.log(myCustomerB.lastName);
