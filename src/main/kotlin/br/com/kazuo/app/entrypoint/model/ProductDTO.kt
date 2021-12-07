package br.com.kazuo.app.entrypoint.model

import io.swagger.v3.oas.annotations.media.Schema
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

class ProductDTO private constructor(
    @Schema(description = "Product's id", example = "1", required = false)
    val id: Int?,
    @Schema(description = "Product's name", example = "Product 1", required = true)
    @Size(max = 30)
    @NotBlank
    val name: String ) {
    data class Builder(
          var id: Int? = null
        , @Size(max = 30) @NotBlank var name: String? = null
    ) {
        fun id(id: Int?) = apply { this.id = id }
        fun name(name: String?) = apply { this.name = name }
        fun build() = ProductDTO(id, name ?: "" )
    }
}