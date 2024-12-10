import { Calzone } from "./Calzone";
import { Pizza } from "./Pizza";
import { Pizzaiolo } from "./Pizzaiolo";
import { Pizzaria } from "./Pizzaria";

const pizzaria = new Pizzaria(['segunda', 'terça', 'quarta', 'quinta', 'sexta', 'sábado'])

const pizzaiolo1 = new Pizzaiolo(new Pizza('pizza de calabresa', ['calabresa', 'queijo', 'tomate']))
const pizzaiolo2 = new Pizzaiolo(new Pizza('pizza de presunto', ['presunto', 'queijo', 'tomate']))

pizzaria.addPizzaiolo(pizzaiolo1)
pizzaria.addPizzaiolo(pizzaiolo2)

pizzaiolo1.addProduct(new Calzone('calzone de calabresa', ['calabresa']))
pizzaiolo2.addProduct(new Calzone('calzone de presunto', ['presunto']))

console.log(pizzaria.printProductsOfDay('terça'))