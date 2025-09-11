import { Executable } from "./executable.interface";

export class Executor {
    run(executables: Executable[]) {
        for (const e of executables) {
            e.execute();
        }
    }
}