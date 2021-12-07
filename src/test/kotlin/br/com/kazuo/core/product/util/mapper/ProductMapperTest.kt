package br.com.kazuo.core.product.util.mapper

import br.com.kazuo.app.entrypoint.model.ProductDTO
import br.com.kazuo.core.product.entity.Product
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable

class ProductMapperTest() {

    private fun fillDto(id: Int?, name: String): ProductDTO {
        return ProductDTO.Builder()
            .id(id)
            .name(name)
            .build()
    }

    @Test
    fun testToEntityOk() {
        var prdNullId: Int? = null
        var prdNullNm = "Product Null Id"
        var prd1Id = 1
        var prd1Nm = "Product 1"


        var dtoNullId = this.fillDto(prdNullId, prdNullNm)
        var dto1 = this.fillDto(prd1Id, prd1Nm)
        Assertions.assertAll(
              Executable { Assertions.assertNull(dtoNullId.toEntity().id, "Asserts that id from dtoNullId is null") }
            , Executable { Assertions.assertEquals(prdNullNm, dtoNullId.toEntity().name, "Asserts that id from dtoNullId is " + prdNullNm) }
            , Executable { Assertions.assertEquals(1, dto1.toEntity().id, "Asserts that id from dto1 is " + prd1Id) }
            , Executable { Assertions.assertEquals("Product 1", dto1.toEntity().name, "Asserts that id from dto1 is " + prd1Nm) }
        )

    }

    private fun fillEntity(id: Int?, name: String): Product {
        return Product(id, name)
    }

    @Test
    fun testToDTOOk() {
        var prdNullId: Int? = null
        var prdNullNm = "Product Null Id"
        var prd1Id = 1
        var prd1Nm = "Product 1"


        var entityNullId = this.fillEntity(prdNullId, prdNullNm)
        var entity1 = this.fillEntity(prd1Id, prd1Nm)
        Assertions.assertAll(
            Executable { Assertions.assertNull(entityNullId.toDTO().id, "Asserts that id from entityNullId is null") }
            , Executable { Assertions.assertEquals(prdNullNm, entityNullId.toDTO().name, "Asserts that id from entityNullId is " + prdNullNm) }
            , Executable { Assertions.assertEquals(1, entity1.toDTO().id, "Asserts that id from entity1 is " + prd1Id) }
            , Executable { Assertions.assertEquals("Product 1", entity1.toDTO().name, "Asserts that id from entity1 is " + prd1Nm) }
        )

    }

}