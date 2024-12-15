import { LogConsole } from "../factory/LogConsole";
import { LogFile } from "../factory/LogFile";

export class LogController {
    private logConsole = new LogConsole();
    private logFile = new LogFile();

    public saveLog(type: string, log: string): void {
        if (type === 'console') {
            this.logConsole.saveLog(log);
        } else {
            this.logFile.saveLog(log);
        }
    }

    public printLogs(type: string): void {
        if (type === 'console') {
            this.logConsole.printLogs();
        } else {
            this.logFile.printLogs();
        }
    }
}