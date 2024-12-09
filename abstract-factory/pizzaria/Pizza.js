"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Pizza = void 0;
var Pizza = /** @class */ (function () {
    function Pizza(name, ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }
    Pizza.prototype.showIngredients = function () {
        console.log(this.name);
        for (var _i = 0, _a = this.ingredients; _i < _a.length; _i++) {
            var i = _a[_i];
            console.log(i);
        }
    };
    Pizza.prototype.getName = function () {
        return this.name;
    };
    return Pizza;
}());
exports.Pizza = Pizza;
