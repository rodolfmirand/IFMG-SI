"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var god_class_1 = require("./god.class");
var utility_class_1 = require("./utility.class");
var executor_class_1 = require("./executor.class");
var god = new god_class_1.GodClass();
var util = new utility_class_1.UtilityClass();
var exec = new executor_class_1.Executor();
exec.run([god, util]);
