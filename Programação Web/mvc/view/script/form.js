import * as productController from '../../controllers/product.controller.js'

const button = document.getElementById('button')
button.addEventListener('click', () => {
    const name = document.getElementById('name')
    const price = document.getElementById('price')
    const category = document.getElementById('category')

    productController.addProduct(name.value, price.value, category.value)


    console.log('product saved')

    const products = productController.findAll()
    
    const productsList = document.getElementById('products')
    productsList.innerHTML = ''
    products.forEach(product => {
        const child = document.createElement('li')
        child.textContent = `Item ${productsList.children.length + 1}: ${product.name} \t R$${product.price} \t ${product.category}`
        productsList.appendChild(child)
    });

})