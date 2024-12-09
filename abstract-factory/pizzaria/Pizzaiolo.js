"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Pizzaiolo = void 0;
var Pizzaiolo = /** @class */ (function () {
    function Pizzaiolo(product) {
        this.products = [];
        this.products.push(product);
    }
    Pizzaiolo.prototype.addProduct = function (product) {
        this.products.push(product);
    };
    Pizzaiolo.prototype.getProduct = function () {
        return this.products;
    };
    Pizzaiolo.prototype.showProducts = function () {
        for (var _i = 0, _a = this.products; _i < _a.length; _i++) {
            var p = _a[_i];
            console.log(p.showIngredients());
        }
    };
    return Pizzaiolo;
}());
exports.Pizzaiolo = Pizzaiolo;
