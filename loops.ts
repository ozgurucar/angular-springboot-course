let numbers: number[] = [1, 3, 3.5, 6, 9, 11]
let sum: number = 0;

for (let number of numbers) {
    sum += number;
}
let average: number = sum / numbers.length;
console.log('Sum of the numbers : ' + average.toFixed(2));