class CustomerB {
    private _firstName: string;
    private _lastName: string;

    constructor(theFirst: string, theLast: string) {
        this._firstName = theFirst;
        this._lastName = theLast;
    }

    public get firstName(): string {
        return this._firstName;
    }

    public get lastName(): string {
        return this._lastName;
    }

    public set firstName(theFirst: string) {
        this._firstName = theFirst;
    }

    public set lastName(theLast: string) {
        this._lastName = theLast;
    }
}

let myCustomerB = new CustomerB("John", "Doe");
myCustomerB.firstName = "Greggu";


console.log(myCustomerB.firstName);
console.log(myCustomerB.lastName);