class CustomerB {
    

    constructor(private _firstName: string,
        private _lastName: string) {
        
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
myCustomerB.firstName = "Gregga";


console.log(myCustomerB.firstName);
console.log(myCustomerB.lastName);