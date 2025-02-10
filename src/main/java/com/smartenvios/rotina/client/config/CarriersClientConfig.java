package com.smartenvios.rotina.client.config;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarriersClientConfig {

    @Value("${apis.carriers.authorization}")
    private String authorization;

    @Bean
    public RequestInterceptor requestInterceptor() {
        return template -> template.header("Authorization", authorization);
    }

}
