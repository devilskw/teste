package br.com.kazuo.app.config

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Contact
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.servers.Server
import org.springdoc.core.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@OpenAPIDefinition(
    info = Info(title = "Products Shelf", description = "A simple example of a products shelf", version = "V1"
    , contact = Contact(name = "Samuel Kazuo Watanabe", email = "samuelkw@gmail.com"))
    , servers = [ Server(url = "http://localhost:8080", description = "local") ]
)
@Configuration
class SwaggerConfig {
    @Bean
    fun productsV1(): GroupedOpenApi {
        return GroupedOpenApi.builder()
            .group("products-shelf-v1")
            .pathsToMatch("/shelf/v1/**")
            .build()
    }
}