import { Coach } from "./Coach";
import { Leader } from "./Leader";  

export class FootballCoach implements Coach, Leader{
    getDailyWorkout(): string {
        return "Shoot 100 times"
    } 
    getMotivation(): string {
        return "You are a great leader!"
    }
}

