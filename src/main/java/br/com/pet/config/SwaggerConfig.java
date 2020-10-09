package br.com.pet.config;

import static springfox.documentation.spi.DocumentationType.SWAGGER_2;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("br.com.pet.controller"))
				.paths(PathSelectors.regex("/.*")).build().apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
	    return new ApiInfo(
	      "Petzin API", 
	      "Test Petz", 
	      "1.0", 
	      "Terms of service", 
	      new Contact("Railson", "railsonsm.com.br", "railson170@hotmail.com"), 
	      "License of API", "API license URL", java.util.Collections.emptyList());
	}

}
