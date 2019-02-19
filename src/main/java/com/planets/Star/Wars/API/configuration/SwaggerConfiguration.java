package com.planets.Star.Wars.API.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {                                    
   
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.planets.Star.Wars.API"))              
          .paths(PathSelectors.ant("/planets/**"))                          
          .build()
          .apiInfo(
        		  new ApiInfoBuilder()
        		  .title("Star Wars Planets API Documentation")
        		  .description("Esta é uma documentação da Rest API Star Wars Planets")
        		  .version("1.0")
        		  .build()
        		  );
	}
}