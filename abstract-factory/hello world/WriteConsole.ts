import { WriteHelloWorld } from "./WriteHelloWorld"

export class WriteConsole implements WriteHelloWorld {
    write(text: string): void {
        console.log(text)
    }
}