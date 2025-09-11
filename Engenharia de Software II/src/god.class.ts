import { Executable } from './executable.interface';

export class GodClass implements Executable {
    public userName: string;
    public temperature: number;
    public logHistory: string[] = [];

    constructor() {
        this.userName = "Anonymous";
        this.temperature = 25.0;
    }

    loginUser(user: string) {
        this.userName = user;
        this.log(`User ${user} logged in.`);
    }

    adjustTemperature(temp: number) {
        this.temperature = temp;
        this.log(`Temperature adjusted to ${temp}`);
    }

    private log(message: string) {
        this.logHistory.push(message);
    }

    execute() {
        console.log("GodClass execution started.");
    }
}