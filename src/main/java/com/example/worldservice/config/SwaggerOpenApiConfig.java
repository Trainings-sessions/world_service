package com.example.worldservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerOpenApiConfig {

     @Value("${open-api-dev-url}")
    private String devUrl;

    @Value("${open-api-stage-url}")
    private String stageUrl;

    @Bean
    public OpenAPI openAPI()
    {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.description("Server URL for Developemnt env");

        Server stageServer = new Server();
        stageServer.setUrl(stageUrl);
        stageServer.description("Server URL for Stage env");

        Contact contact = new Contact();
        contact.setEmail("priyankapruthe@gmail.com");
        contact.setName("VasanthaRama");
        contact.setUrl("https://vasantharama.com");

        License license = new License().name("MIT License").url("https://license.com");

        Info info = new Info()
                .contact(contact)
                .license(license)
                .version("1.0")
                .description("This API provides endpoints to manage World cities")
                .termsOfService("https://vasantharama.com/terms");

        return new OpenAPI().info(info).servers(List.of(devServer,stageServer));
    }
}
