// Javascriptteki var yerine let komutu kullanılır.

// let is_active: boolean = true;
// let age: number = 25;
// let firstname: string = "John";

// is_active = false;
// console.log(is_active + " " + age + " " + firstname);

for (let i=0; i<5; i++) {
    console.log(i);
}

let testarray: number[] = [1,2,3,4,5];
let sports: string[] = ["Football", "Basketball", "Volleyball"];

sports.push("Tennis");


for (let tempSport of sports) {
    console.log(tempSport);
}
