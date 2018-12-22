package com.dvoretskyi.department.config;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("com.dvoretskyi.department")
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer {
  @Value("${origin-url:http://localhost:4200}")
  private String originURL;
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/api/**").allowedOrigins(originURL)
        .allowedMethods("GET", "POST","PUT","DELETE","OPTION")
        .allowedHeaders("Content-Type", "X-Requested-With", "accept", "Origin",
            "Access-Control-Request-Method", "Access-Control-Request-Headers")
        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
        .allowCredentials(true);
  }
  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
    builder.indentOutput(true);
    converters.add(new MappingJackson2HttpMessageConverter(builder.build()));
  }
} 