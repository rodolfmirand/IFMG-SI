"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const DatabaseInMemory_1 = require("./database/DatabaseInMemory");
const FirstLastName_1 = require("./factory/FirstLastName");
const LastFirstName_1 = require("./factory/LastFirstName");
let database = new DatabaseInMemory_1.DatabaseInMemory();
let factory = new FirstLastName_1.FirstLastName(database);
let factory2 = new LastFirstName_1.LastFirstName(database);
function saveName(name) {
    name.indexOf(',') !== -1 ? factory2.save(name) : factory.save(name);
}
saveName('McNealy, Scott');
saveName('James Gosling');
saveName('Naughton, Patrick');
console.log(factory.getNames());
console.log(factory2.getNames());
