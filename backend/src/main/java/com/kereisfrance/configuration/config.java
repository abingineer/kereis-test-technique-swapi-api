package com.kereisfrance.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class config {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}