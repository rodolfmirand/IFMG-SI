"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.LastFirstName = void 0;
class LastFirstName {
    constructor(database) {
        this.database = database;
    }
    save(fullname) {
        const name = fullname.split(', ');
        this.database.save(name[1], name[0]);
    }
    getNames() {
        return this.database.getAll();
    }
}
exports.LastFirstName = LastFirstName;
