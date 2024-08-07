package com.devreis.dailydiet.infra.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {
    @Bean
  public OpenAPI openAPI() {
    return new OpenAPI()
        .info(new Info().title("Daily diet").description("API para controle de dieta diária, a Daily Diet API.").version("1"))
        .schemaRequirement("jwt_auth", creaSecurityScheme());
  }

  private SecurityScheme creaSecurityScheme() {
    return new SecurityScheme().name("jwt_auth").type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT");
  }
}
