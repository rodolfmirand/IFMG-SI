import { Database } from "../database/Database";
import { Fullname } from "./interface/Fullname";

export class LastFirstName implements Fullname {

    constructor(readonly database: Database) { }

    public save(fullname: string): void {
        const name = fullname.split(', ')
        this.database.save(name[1], name[0])
    }

    public getNames(): string[] {
        return this.database.getAll();
    }
}