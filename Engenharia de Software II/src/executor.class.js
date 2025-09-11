"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Executor = void 0;
var Executor = /** @class */ (function () {
    function Executor() {
    }
    Executor.prototype.run = function (executables) {
        for (var _i = 0, executables_1 = executables; _i < executables_1.length; _i++) {
            var e = executables_1[_i];
            e.execute();
        }
    };
    return Executor;
}());
exports.Executor = Executor;
