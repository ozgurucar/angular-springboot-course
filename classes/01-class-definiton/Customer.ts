class Customer {
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

let myCustomer = new Customer("John", "Doe");
myCustomer.firstName = "Greg";


console.log(myCustomer.firstName);
console.log(myCustomer.lastName);