"use strict";
let numbers = [1, 3, 3.5, 6, 9, 11];
let sum = 0;
for (let number of numbers) {
    sum += number;
}
let average = sum / numbers.length;
console.log('Sum of the numbers : ' + average.toFixed(2));
