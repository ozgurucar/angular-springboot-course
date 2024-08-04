import { Customer } from './Customer';

let myCustomer = new Customer("Martin", "Dixon");

myCustomer.firstName = "Changed";

console.log(myCustomer.firstName + " " + myCustomer.lastName);