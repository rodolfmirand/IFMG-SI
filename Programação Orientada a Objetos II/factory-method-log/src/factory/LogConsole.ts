import { Log } from "./Log";

export class LogConsole implements Log {

    private logs: string[] = [];

    public saveLog(log: string): void {
        this.logs.push(log);
    }

    public printLogs(): void {
        console.log("Logs: ");
        this.logs.forEach((log) => {
            console.log(log);
        })
    }
}