var CustomerB = /** @class */ (function () {
    function CustomerB(theFirst, theLast) {
        this._firstName = theFirst;
        this._lastName = theLast;
    }
    Object.defineProperty(CustomerB.prototype, "firstName", {
        get: function () {
            return this._firstName;
        },
        set: function (theFirst) {
            this._firstName = theFirst;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(CustomerB.prototype, "lastName", {
        get: function () {
            return this._lastName;
        },
        set: function (theLast) {
            this._lastName = theLast;
        },
        enumerable: false,
        configurable: true
    });
    return CustomerB;
}());
var myCustomerB = new CustomerB("John", "Doe");
myCustomerB.firstName = "Greggu";
console.log(myCustomerB.firstName);
console.log(myCustomerB.lastName);
