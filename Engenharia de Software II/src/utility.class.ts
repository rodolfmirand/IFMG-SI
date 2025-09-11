import { Executable } from './executable.interface';

export class UtilityClass implements Executable {
    public numbers: number[] = [];
    public isSystemOnline: boolean = false;

    addNumber(n: number) {
        this.numbers.push(n);
    }

    toggleSystemStatus() {
        this.isSystemOnline = !this.isSystemOnline;
    }

    execute() {
        console.log("UtilityClass executed something meaningless.");
    }
}