package com.miguecode.market.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration // Indica que es una clase de configuración
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select() // Selecciona los elementos que se van a mostrar en la documentación
                .apis(RequestHandlerSelectors.basePackage("com.miguecode.market.web.controller"))
                .build();
    }
}
