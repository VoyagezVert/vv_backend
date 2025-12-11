plugins {
	java
    //id("jacoco")
    //id("maven-publish")
    id("org.springframework.boot") version "4.0.0-RC1"
    id("io.spring.dependency-management") version "1.1.7"
    //id("org.springframework.cloud.contract") version "5.0.0-M4"
    //id("org.asciidoctor.jvm.convert") version "4.0.5"
}

val projectVersionFile = file(".version")
val projectVersion = if (projectVersionFile.exists()) {
    projectVersionFile.readText().trim()
} else {
    "0.0.0-SNAPSHOT"
}

group = "com.voyagezvert"
version = projectVersion
description = "Backend for VoyagezVert"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(25)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

//extra["snippetsDir"] = file("build/generated-snippets")
//extra["springCloudVersion"] = "2025.0.0"

dependencies {
    // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jdbc
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc:4.0.0-RC1")
    // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:4.0.0-RC1")
    // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-security
    implementation("org.springframework.boot:spring-boot-starter-security:4.0.0-RC1")
    // https://mvnrepository.com/artifact/org.projectlombok/lombok
	compileOnly("org.projectlombok:lombok:1.18.42")
    // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-devtools/4.0.0-RC1
	developmentOnly("org.springframework.boot:spring-boot-devtools:4.0.0-RC1")
    //org.springframework.boot:spring-boot-docker-compose:4.0.0-RC1"
	//developmentOnly("org.springframework.boot:spring-boot-docker-compose:4.0.0-RC1")
    // https://mvnrepository.com/artifact/org.postgresql/postgresql/42.7.8
	runtimeOnly("org.postgresql:postgresql:42.7.8")
    // https://mvnrepository.com/artifact/org.projectlombok/lombok
	annotationProcessor("org.projectlombok:lombok")
    implementation("io.github.cdimascio:dotenv-java:3.0.0")
    // https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-starter-webmvc-ui
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:3.0.0-RC1")
    implementation("org.springframework.boot:spring-boot-starter-web:4.0.0-RC1")
    // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test
	//testImplementation("org.springframework.boot:spring-boot-starter-test:4.0.0-RC1")
    // https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-contract-verifier/5.0.0-M4
	//testImplementation("org.springframework.cloud:spring-cloud-starter-contract-verifier:5.0.0-M4")
    // https://mvnrepository.com/artifact/org.springframework.restdocs/spring-restdocs-mockmvc/4.0.0-RC1
	//testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc:4.0.0-RC1")
    // https://mvnrepository.com/artifact/org.springframework.security/spring-security-test/7.0.0-RC1
	//testImplementation("org.springframework.security:spring-security-test:7.0.0-RC1")
    // https://mvnrepository.com/artifact/org.junit.platform/junit-platform-launcher/6.0.0
	//testRuntimeOnly("org.junit.platform:junit-platform-launcher:6.0.0")
    // https://mvnrepository.com/artifact/org.mockito/mockito-core/5.20.0
    //testImplementation("org.mockito:mockito-core:5.20.0")
    // https://mvnrepository.com/artifact/org.mockito/mockito-junit-jupiter/5.20.0
    //testImplementation("org.mockito:mockito-junit-jupiter:5.20.0")
    // https://mvnrepository.com/artifact/org.assertj/assertj-core/4.0.0-M1
    //testImplementation("org.assertj:assertj-core:4.0.0-M1")
    // https://mvnrepository.com/artifact/org.hamcrest/hamcrest/3.0
    //testImplementation("org.hamcrest:hamcrest:3.0")
}

/*dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}*/

tasks.withType<JavaExec> {
    environment("DOTENV_FILE", ".env.prod")
}

/*contracts {
}*/

tasks.build {
    //dependsOn(tasks.test)
}

/*tasks.withType<Test> {
	useJUnitPlatform()
}*/

/*tasks.contractTest {
	useJUnitPlatform()
}*/

/*tasks.test {
	outputs.dir(project.extra["snippetsDir"]!!)
}*/

/*tasks.asciidoctor {
	inputs.dir(project.extra["snippetsDir"]!!)
	//dependsOn(tasks.test)
}*/
