package br.com.kazuo.app.config

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable

class SwaggerConfigTest {

    @Test
    fun testProductsV1() {
        val cfg = SwaggerConfig()
        Assertions.assertAll(
              Executable { Assertions.assertNotNull(cfg.productsV1()) }
            , Executable { Assertions.assertEquals("products-shelf-v1", cfg.productsV1().group) }
        )
    }
}