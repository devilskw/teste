package br.com.kazuo.app.entrypoint

import br.com.kazuo.app.entrypoint.model.ProductDTO
import br.com.kazuo.core.product.usecase.IProductService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/shelf/v1"])
class RequestsController(@Autowired val service: IProductService) {

    @Operation(
          tags = ["Requests"]
        , operationId = "shelfV1GetProductsList"
        , summary = "Products' list"
        , description = "Gets a list of products"
    )
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "successful operation",
            content = [ Content(array = ArraySchema(schema = Schema(implementation = ProductDTO::class))) ]
        )])
    @GetMapping(path = ["/requests/json"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getList() = this.service.listProducts()

}