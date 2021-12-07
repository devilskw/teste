package br.com.kazuo.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import springfox.documentation.oas.annotations.EnableOpenApi

@SpringBootApplication(scanBasePackages = ["br.com.kazuo"])
@EnableOpenApi
class ProductApplication

fun main(args: Array<String>) {
	runApplication<ProductApplication>(*args)
}
