import { Shape } from "./Shape"
 
export class Rectangle extends Shape{
    constructor(theX: number, theY: number, private _width: number, private _length: number) {
        super(theX, theY);
    }


    public getInfo(): string {
        return (super.getInfo() + ` Width: ${this._width}, Length: ${this._length}`)
    }
}