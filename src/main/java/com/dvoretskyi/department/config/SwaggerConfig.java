package com.dvoretskyi.department.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The type Swagger config.
 */
@Configuration
@EnableWebMvc
@EnableSwagger2
public class SwaggerConfig {

  private static final String SWAGGER_API_VERSION = "1.0";
  private static final String LICENSE_TEXT = "License";
  private static final String title = "Spring Boot Start";
  private static final String description = "Documentation for the project";

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title(title)
        .description(description)
        .license(LICENSE_TEXT)
        .version(SWAGGER_API_VERSION)
        .build();
  }

  /**
   * Decks api docket.
   *
   * @return the docket
   */
  @Bean
  public Docket decksApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .pathMapping("/")
        .select()
        .paths(PathSelectors.any())
        .build();
  }

}