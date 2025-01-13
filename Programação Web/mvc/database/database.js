let products = []

export function save(product) {
    products.push(product)
    return true
}

export function findAll() {
    return products
}