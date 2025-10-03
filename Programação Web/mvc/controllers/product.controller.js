import * as database from '../database/database.js'
import { Product } from '../models/product.model.js'

export function addProduct(name, price, category) {
    return database.save(new Product(name, price, category))
}

export function findAll() {
    return database.findAll()
}