"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Shape = void 0;
class Shape {
    constructor(x, y) {
        this.x = x;
        this.y = y;
    }
    get xVariable() {
        return this.x;
    }
    get yVariable() {
        return this.y;
    }
    set xVariable(theX) {
        this.x = theX;
    }
    set yVariable(theY) {
        this.y = theY;
    }
    getInfo() {
        return `x= ${this.x}, y= ${this.y}`;
    }
}
exports.Shape = Shape;
