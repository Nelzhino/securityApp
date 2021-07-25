package com.jwtExample.securityApp.security;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.jwtExample.securityApp.controllers")).build()
				.apiInfo(apiInfo())
				.securitySchemes(Collections.singletonList(key()));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Api de example de JWT").description("Rest API")
				.termsOfServiceUrl("localhost").version("1.0")
				.contact(new Contact("Nelson", "https://test.com", "nelzhino007@gmail.com")).build();
	}
	
	private ApiKey key() {
		return new ApiKey("jwtToken", "Authorization", "header");
	}
}
