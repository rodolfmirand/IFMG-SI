export interface Product {
    name: string
    ingredients: string[]

    showIngredients(): void
    getName(): string
}