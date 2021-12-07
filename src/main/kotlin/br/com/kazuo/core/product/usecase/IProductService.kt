package br.com.kazuo.core.product.usecase

import br.com.kazuo.app.entrypoint.model.ProductDTO
import org.springframework.stereotype.Service

interface IProductService {
    fun listProducts(): List<ProductDTO>
}