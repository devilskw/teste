import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	application
	id("org.springframework.boot") version "2.5.3"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.5.21"
	kotlin("plugin.allopen") version "1.5.21"
	kotlin("plugin.spring") version "1.5.21"
	// oas 3.0
	id("com.github.johnrengelman.processes") version "0.5.0"
	id("org.springdoc.openapi-gradle-plugin") version "1.3.2"
}

val appGroup = project.properties.get("appGroup") as String
val appVersion = project.properties.get("appVersion") as String
val appMain = StringBuilder().append(appGroup)
	.append(".").append(project.properties.get("appMainPack"))
	.append(".").append(project.properties.get("appMainName")).toString()
val mockkVersion = project.properties.get("mockkVersion") as String
val springdocVersion = project.properties.get("springdocVersion") as String
val springfoxVersion = project.properties.get("springfoxVersion") as String

version = appVersion
group = appGroup
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-hateoas")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	// swagger oas
	implementation("org.springdoc:springdoc-openapi-ui:${springdocVersion}")
	implementation("org.springdoc:springdoc-openapi-data-rest:${springdocVersion}")
	implementation("io.springfox:springfox-boot-starter:${springfoxVersion}")
	implementation("org.springframework.data:spring-data-rest-webmvc:3.5.4")
	implementation("org.springframework.boot:spring-boot-configuration-processor")
	implementation("org.springframework.boot:spring-boot-gradle-plugin:2.5.3")

}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

application {
	mainClass.set(appMain)
}

openApi{
	apiDocsUrl.set("http://localhost:8080/v1/api-docs.yaml")
	outputDir.set(file("$buildDir/contracts"))
	outputFileName.set("openapi-contract.yaml")
	waitTimeInSeconds.set(30)
	forkProperties.set("-Dspring.profiles.active=special")
}

sourceSets {
	main {
		output.dir(mapOf("generateOpenApiDocs" to "generateOpenApiDocs"),  "$buildDir/contracts")
	}
}