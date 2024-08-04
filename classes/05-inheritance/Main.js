"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const Circle_1 = require("./Circle");
const Shape_1 = require("./Shape");
const Rectangle_1 = require("./Rectangle");
let myShape = new Shape_1.Shape(10, 15);
let myCircle = new Circle_1.Circle(5, 10, 20);
let myRectangle = new Rectangle_1.Rectangle(10, 12, 5, 7);
let Shapes = [];
Shapes.push(myShape, myRectangle, myCircle);
for (let tempShape of Shapes) {
    console.log(tempShape.getInfo());
}
