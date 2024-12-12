import { DatabaseInMemory } from "./database/DatabaseInMemory";
import { FirstLastName } from "./factory/FirstLastName";
import { LastFirstName } from "./factory/LastFirstName";

let database = new DatabaseInMemory()

let factory = new FirstLastName(database)
let factory2 = new LastFirstName(database)


function saveName(name: string): void {
    name.indexOf(',') !== -1 ? factory2.save(name) : factory.save(name)
}

saveName('McNealy, Scott')
saveName('James Gosling')
saveName('Naughton, Patrick')

console.log(factory.getNames())
console.log(factory2.getNames())
