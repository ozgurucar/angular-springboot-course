export class Shape {
    constructor(private x: number,
        private y: number) {

    }

    get xVariable(): number {
        return this.x;
    }

    get yVariable(): number {
        return this.y;
    }

    set xVariable(theX: number) {
        this.x = theX;
    }

    set yVariable(theY: number) {
        this.y = theY;
    }

    public getInfo(): string {
        return `x= ${this.x}, y= ${this.y}`;
    }
}