import { Circle } from "./Circle";
import { Shape } from "./Shape";
import { Rectangle } from "./Rectangle";

let myShape = new Shape(10, 15);
let myCircle = new Circle(5, 10, 20);
let myRectangle = new Rectangle(10, 12, 5, 7);

let Shapes: Shape[] = [];

Shapes.push(myShape, myRectangle, myCircle);

for (let tempShape of Shapes) {
    console.log(tempShape.getInfo());
}