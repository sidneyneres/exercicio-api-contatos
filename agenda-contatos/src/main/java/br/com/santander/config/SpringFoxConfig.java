package br.com.santander.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).securitySchemes(java.util.Collections.singletonList(new ApiKey("SwaggerAutentic", HttpHeaders.AUTHORIZATION, io.swagger.models.auth.In.HEADER.name())))
				.select().apis(RequestHandlerSelectors.basePackage("br.com.santander.controller"))
				.paths(PathSelectors.any()).build();
	}

}