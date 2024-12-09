import { Product } from "./Product";

export class Pizza implements Product {
    name: string
    ingredients: string[]

    constructor(name: string, ingredients: string[]) {
        this.name = name
        this.ingredients = ingredients
    }

    showIngredients(): void {
        console.log(this.name)
        for (let i of this.ingredients) {
            console.log(i)
        }
    }

    getName(): string {
        return this.name
    }
}