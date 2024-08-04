"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Customer = void 0;
class Customer {
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
exports.Customer = Customer;
