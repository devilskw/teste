package br.com.kazuo.app.entrypoint

import br.com.kazuo.app.entrypoint.model.ProductDTO
import br.com.kazuo.core.product.usecase.IProductService
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@WebMvcTest(controllers = [RequestsController::class])
class ProductsControllerTest(@Autowired val mvc:MockMvc) {

    @MockBean
    private lateinit var service: IProductService

    @Test
    fun testListProductsOk() {
        Mockito.`when`(service.listProducts()).thenReturn(
            listOf<ProductDTO>(
                ProductDTO.Builder()
                    .id(1)
                    .name("Product 1")
                    .build()
                , ProductDTO.Builder()
                    .id(2)
                    .name("Product 2")
                    .build()
            )
        )
        mvc.get("/shelf/v1/products").andExpect {
            status { is2xxSuccessful() }
            content { contentType(MediaType.APPLICATION_JSON) }
            jsonPath("\$[0].id", `is`(1))
            jsonPath("\$[0].name", `is`("Product 1") )
            jsonPath("\$[1].id", `is`(2) )
            jsonPath("\$[1].name", `is`("Product 2") )
        }

    }


}