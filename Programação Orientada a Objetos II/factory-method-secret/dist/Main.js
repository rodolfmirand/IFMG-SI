"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var PrivateProvider_1 = require("./factory/PrivateProvider");
var PublicProvider_1 = require("./factory/PublicProvider");
var publicProvider = new PublicProvider_1.PublicProvider();
var privateProvider = new PrivateProvider_1.PrivateProvider();
publicProvider.acessFile();
privateProvider.acessFile('designpatterns');
