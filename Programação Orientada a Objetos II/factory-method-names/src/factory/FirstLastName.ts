import { Database } from "../database/Database";
import { Fullname } from "./interface/Fullname";

export class FirstLastName implements Fullname {

    constructor(readonly database: Database) { }
    
    public save(fullname: string): void {
        const name = fullname.split(' ')
        this.database.save(name[0], name[1]);
    }

    public getNames(): string[] {
        return this.database.getAll();
    }
}