"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.WriteConsole = void 0;
var WriteConsole = /** @class */ (function () {
    function WriteConsole() {
    }
    WriteConsole.prototype.write = function (text) {
        console.log(text);
    };
    return WriteConsole;
}());
exports.WriteConsole = WriteConsole;
