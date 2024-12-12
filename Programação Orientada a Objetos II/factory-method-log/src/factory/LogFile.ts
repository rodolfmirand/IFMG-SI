import { Log } from "./Log";
import * as fs from 'fs'

export class LogFile implements Log {

    saveLog(log: string): void {
        fs.appendFileSync('log.txt', log + '\n');
    }

    printLogs(): void {
        fs.readFileSync('log.txt', 'utf-8').split('\n').forEach((log) => {
            console.log(log);
        });
    }

}