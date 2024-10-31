package com.kereisfrance.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfiguration {

    @Bean
    public OpenAPI defineOpenApi() {
        Server recette = new Server();
        recette.setUrl("http://localhost:8080");
        recette.setDescription("recette");

        Contact contact = new Contact();
        contact.setName("Aboubaar DIALLO");
        contact.setEmail("aboubacard659@gmail.com");

        Info info = new Info();
        info.title("Communication avec star wars api");
        info.setVersion("1.0");
        info.description("Ce backend expose des api rest pour la communication avec star wars api");
        info.setContact(contact);

        return new OpenAPI()
                .info(info)
                .servers(
                        List.of(
                                recette
                        )
                );

    }
}
