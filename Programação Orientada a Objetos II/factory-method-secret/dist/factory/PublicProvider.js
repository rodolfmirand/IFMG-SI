"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.PublicProvider = void 0;
var fs = require("fs");
var PublicProvider = /** @class */ (function () {
    function PublicProvider() {
        this.password = 'designpatterns';
        this.file = 'public.txt';
    }
    PublicProvider.prototype.acessFile = function () {
        var data = fs.readFileSync(this.file, 'utf8');
        console.log(data);
    };
    return PublicProvider;
}());
exports.PublicProvider = PublicProvider;
