import { Shape } from "./Shape"

export class Circle extends Shape {
    constructor (private radius : number) {
   super();
    }

    public calculateArea(): number {
        return Math.PI * Math.pow(this.radius, 2);
    }

}