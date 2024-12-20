"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var Calzone_1 = require("./Calzone");
var Pizza_1 = require("./Pizza");
var Pizzaiolo_1 = require("./Pizzaiolo");
var Pizzaria_1 = require("./Pizzaria");
var pizzaria = new Pizzaria_1.Pizzaria(['segunda', 'terça', 'quarta', 'quinta', 'sexta', 'sábado']);
var pizzaiolo1 = new Pizzaiolo_1.Pizzaiolo(new Pizza_1.Pizza('pizza de calabresa', ['calabresa', 'queijo', 'tomate']));
var pizzaiolo2 = new Pizzaiolo_1.Pizzaiolo(new Pizza_1.Pizza('pizza de presunto', ['presunto', 'queijo', 'tomate']));
pizzaria.addPizzaiolo(pizzaiolo1);
pizzaria.addPizzaiolo(pizzaiolo2);
pizzaiolo1.addProduct(new Calzone_1.Calzone('calzone de calabresa', ['calabresa']));
pizzaiolo2.addProduct(new Calzone_1.Calzone('calzone de presunto', ['presunto']));
console.log(pizzaria.printProductsOfDay('segunda'));
