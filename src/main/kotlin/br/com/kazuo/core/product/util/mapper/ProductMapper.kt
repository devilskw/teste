package br.com.kazuo.core.product.util.mapper

import br.com.kazuo.app.entrypoint.model.ProductDTO
import br.com.kazuo.core.product.entity.Product

class ProductMapper

fun ProductDTO.toEntity(): Product {
    return Product(this.id, this.name)
}

fun Product.toDTO(): ProductDTO {
    return ProductDTO.Builder()
        .id(this.id)
        .name(this.name)
        .build()
}