"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Calzone = void 0;
var Calzone = /** @class */ (function () {
    function Calzone(name, ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }
    Calzone.prototype.showIngredients = function () {
        console.log(this.name);
        for (var _i = 0, _a = this.ingredients; _i < _a.length; _i++) {
            var i = _a[_i];
            console.log(i);
        }
    };
    Calzone.prototype.getName = function () {
        return this.name;
    };
    return Calzone;
}());
exports.Calzone = Calzone;
