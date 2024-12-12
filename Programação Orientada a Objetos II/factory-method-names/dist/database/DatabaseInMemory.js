"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.DatabaseInMemory = void 0;
const Name_1 = require("../model/Name");
class DatabaseInMemory {
    constructor() {
        this.names = [];
    }
    save(firstname, surname) {
        this.names.push(new Name_1.Name(firstname, surname));
    }
    getAll() {
        return this.names.map(name => name.getFullName());
    }
}
exports.DatabaseInMemory = DatabaseInMemory;
