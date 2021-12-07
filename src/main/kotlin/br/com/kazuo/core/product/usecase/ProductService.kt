package br.com.kazuo.core.product.usecase

import br.com.kazuo.app.entrypoint.model.ProductDTO
import org.springframework.stereotype.Service

@Service
class ProductService: IProductService {
    override fun listProducts(): List<ProductDTO> {
        return listOf(
              ProductDTO.Builder().id(1).name("Produto 1").build()
            , ProductDTO.Builder().id(2).name("Produto 2").build()
            , ProductDTO.Builder().id(3).name("Produto 3").build()
            , ProductDTO.Builder().id(4).name("Produto 4").build()
        )
    }
}