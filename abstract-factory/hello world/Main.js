"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var WriteConsole_1 = require("./WriteConsole");
var WriteTxt_1 = require("./WriteTxt");
var PrintHelloWorld = /** @class */ (function () {
    function PrintHelloWorld() {
    }
    PrintHelloWorld.prototype.print = function () {
        var writeTxt = new WriteTxt_1.WriteTxt();
        var writeConsole = new WriteConsole_1.WriteConsole();
        var text = "Hello World!";
        if ((Math.floor(Math.random() * 10) + 1) % 2 === 0) {
            writeTxt.write(text);
        }
        else {
            writeConsole.write(text);
        }
    };
    return PrintHelloWorld;
}());
var printer = new PrintHelloWorld();
printer.print();
