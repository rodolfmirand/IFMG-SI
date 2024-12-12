"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.FirstLastName = void 0;
class FirstLastName {
    constructor(database) {
        this.database = database;
    }
    save(fullname) {
        const name = fullname.split(' ');
        this.database.save(name[0], name[1]);
    }
    getNames() {
        return this.database.getAll();
    }
}
exports.FirstLastName = FirstLastName;
