"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Pizzaria = void 0;
var Pizzaria = /** @class */ (function () {
    function Pizzaria(days) {
        this.pizzaiolos = [];
        this.schedule = new Map;
        this.days = days;
    }
    Pizzaria.prototype.verifyDay = function (day) {
        for (var _i = 0, _a = this.days; _i < _a.length; _i++) {
            var d = _a[_i];
            if (day == d)
                return true;
        }
        return false;
    };
    Pizzaria.prototype.addPizzaiolo = function (pizzaiolo) {
        if (this.pizzaiolos.length == 0) {
            for (var i = 0; i < this.days.length; i += 2) {
                this.schedule.set(this.days[i], pizzaiolo);
            }
        }
        else {
            for (var i = 1; i < this.days.length; i += 2) {
                this.schedule.set(this.days[i], pizzaiolo);
            }
        }
        this.pizzaiolos.push(pizzaiolo);
    };
    Pizzaria.prototype.printProductsOfDay = function (day) {
        this.verifyDay(day) ? this.printProducts(this.schedule.get(day)) : "closed";
    };
    Pizzaria.prototype.printProducts = function (pizzaiolo) {
        if (pizzaiolo == undefined)
            return;
        pizzaiolo.showProducts();
    };
    return Pizzaria;
}());
exports.Pizzaria = Pizzaria;
