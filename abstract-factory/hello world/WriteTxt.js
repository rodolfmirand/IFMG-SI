"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.WriteTxt = void 0;
var fs_1 = require("fs");
var WriteTxt = /** @class */ (function () {
    function WriteTxt() {
    }
    WriteTxt.prototype.write = function (text) {
        var path = "D:/Perfil/rodolfo.miranda/Desktop/Rodolfo/IFMG-SI/abstract-factory/hello-world.txt";
        (0, fs_1.writeFile)(path, text, function (err) {
            if (err) {
                console.error('Erro', err);
            }
        });
    };
    return WriteTxt;
}());
exports.WriteTxt = WriteTxt;
