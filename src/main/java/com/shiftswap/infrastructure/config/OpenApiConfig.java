package com.shiftswap.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Value("${application.version}")
    private String applicationVersion;

    @Bean
    public OpenAPI shiftSwapOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("ShiftSwap API")
                        .description("REST API for ShiftSwap - Healthcare Shift Management Application")
                        .version(applicationVersion)
                        .contact(new Contact()
                                .name("ShiftSwap Team")
                                .email("support@shiftswap.com")))
                .servers(List.of(
                        new Server().url("/").description("Default Server")
                ));
    }
}
