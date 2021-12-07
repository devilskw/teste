package br.com.kazuo.app

import br.com.kazuo.app.config.SwaggerConfig
import br.com.kazuo.app.entrypoint.RequestsController
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.data.rest.webmvc.BasePathAwareHandlerMapping
import springfox.documentation.spring.data.rest.BasePathAwareServicesProvider
import springfox.documentation.spring.web.plugins.DocumentationPluginsBootstrapper
import springfox.documentation.swagger.web.InMemorySwaggerResourcesProvider

@SpringBootTest(classes = [ProductApplication::class])
class ProductApplicationTests() {

	@MockBean
	private lateinit var requestsController: RequestsController

	@MockBean
	private lateinit var swaggerCfg: SwaggerConfig

	@MockBean
	private lateinit var basePathAwareServicesProvider: BasePathAwareServicesProvider

	@MockBean
	private lateinit var basePathAwareHandlerMapping: BasePathAwareHandlerMapping

	@MockBean
	private lateinit var inMemorySwaggerResourcesProvider: InMemorySwaggerResourcesProvider

	@MockBean
	private lateinit var documentationPluginsBootstrapper: DocumentationPluginsBootstrapper

	@Test
	fun contextLoads() {}

}
