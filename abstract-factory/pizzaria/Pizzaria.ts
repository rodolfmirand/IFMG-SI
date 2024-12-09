import { Pizzaiolo } from "./Pizzaiolo";
import { Product } from "./Product";

export class Pizzaria {
    days: string[]
    pizzaiolos: Pizzaiolo[] = []
    schedule = new Map<string, Pizzaiolo>

    constructor(days: string[]) {
        this.days = days
    }

    verifyDay(day: string): boolean {
        for (let d of this.days) {
            if (day == d) return true
        }
        return false
    }

    addPizzaiolo(pizzaiolo: Pizzaiolo): void {
        if (this.pizzaiolos.length == 0) {
            for (let i = 0; i < this.days.length; i += 2) {
                this.schedule.set(this.days[i], pizzaiolo);
            }
        } else {
            for (let i = 1; i < this.days.length; i += 2) {
                this.schedule.set(this.days[i], pizzaiolo);
            }
        }
        this.pizzaiolos.push(pizzaiolo)

    }

    printProductsOfDay(day: string): void {
        this.verifyDay(day) ? this.printProducts(this.schedule.get(day)) : "closed"
    }

    printProducts(pizzaiolo: Pizzaiolo | undefined): void {
        if (pizzaiolo == undefined) return
        pizzaiolo.showProducts()
    }
}