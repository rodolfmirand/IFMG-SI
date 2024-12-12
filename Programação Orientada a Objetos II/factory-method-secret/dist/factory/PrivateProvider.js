"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.PrivateProvider = void 0;
var fs = require("fs");
var PrivateProvider = /** @class */ (function () {
    function PrivateProvider() {
        this.password = 'designpatterns';
        this.file = 'confidential.txt';
    }
    PrivateProvider.prototype.acessFile = function (password) {
        if (password === this.password) {
            var data = fs.readFileSync(this.file, 'utf8');
            console.log(data);
        }
        else {
            console.log('Wrong password');
        }
    };
    return PrivateProvider;
}());
exports.PrivateProvider = PrivateProvider;
