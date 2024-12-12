import { LogController } from "./controller/LogController";

let logController = new LogController();

logController.saveLog('console', 'This is a console log');
logController.saveLog('console', 'This is a console log');
logController.saveLog('console', 'This is a console log');
logController.saveLog('console', 'This is a console log');
logController.saveLog('console', 'This is a console log');
logController.saveLog('console', 'This is a console log');
logController.saveLog('console', 'This is a console log');
logController.saveLog('console', 'This is a console log');
logController.saveLog('console', 'This is a console log');
logController.saveLog('console', 'This is a console log');
logController.saveLog('console', 'This is a console log');

logController.saveLog('file', 'This is a file log');
logController.saveLog('file', 'This is a file log');
logController.saveLog('file', 'This is a file log');
logController.saveLog('file', 'This is a file log');
logController.saveLog('file', 'This is a file log');
logController.saveLog('file', 'This is a file log');
logController.saveLog('file', 'This is a file log');
logController.saveLog('file', 'This is a file log');
logController.saveLog('file', 'This is a file log');
logController.saveLog('file', 'This is a file log');

logController.printLogs('console');
logController.printLogs('file');