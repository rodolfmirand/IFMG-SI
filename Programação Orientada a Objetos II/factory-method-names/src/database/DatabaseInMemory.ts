import { Name } from "../model/Name";
import { Database } from "./Database";

export class DatabaseInMemory implements Database{
    private names: Array<Name> = [];

    public save(firstname: string, surname: string): void {
        this.names.push(new Name(firstname, surname));
    }

    public getAll(): string[] {
        return this.names.map(name => name.getFullName());
    }
}