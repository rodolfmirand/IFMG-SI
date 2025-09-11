"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.UtilityClass = void 0;
var UtilityClass = /** @class */ (function () {
    function UtilityClass() {
        this.numbers = [];
        this.isSystemOnline = false;
    }
    UtilityClass.prototype.addNumber = function (n) {
        this.numbers.push(n);
    };
    UtilityClass.prototype.toggleSystemStatus = function () {
        this.isSystemOnline = !this.isSystemOnline;
    };
    UtilityClass.prototype.execute = function () {
        console.log("UtilityClass executed something meaningless.");
    };
    return UtilityClass;
}());
exports.UtilityClass = UtilityClass;
