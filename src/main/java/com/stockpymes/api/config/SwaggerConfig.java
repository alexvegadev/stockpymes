package com.stockpymes.api.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Alex P. Vega
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.stockpymes.api.rest"))
				.paths(PathSelectors.any())
				.build();
	}
	
	protected ApiInfo getApiInfo() {
		return new ApiInfo(
				"Stock Pymes Controler", 
				"Stock controler for PyMES(small and medium businesses)",
				"1.0", 
				"TERMS OF SERVICE URL",
				new Contact("Alex G. Peiretti", "URL", "alexvegadev@gmail.com"),
				"LICENSE", 
				"LICENSE URL", Collections.emptyList());
	}
}
