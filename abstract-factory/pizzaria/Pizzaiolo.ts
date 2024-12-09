import { Product } from "./Product"

export class Pizzaiolo {
    products: Product[] = []

    constructor(product: Product) {
        this.products.push(product)
    }

    addProduct(product: Product){
        this.products.push(product)
    }

    getProduct(): Product[] {
        return this.products
    }

    showProducts(): void {
        for(let p of this.products){
            console.log(p.showIngredients())
        }
    }
}