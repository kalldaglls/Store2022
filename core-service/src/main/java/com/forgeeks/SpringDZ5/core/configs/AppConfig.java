package com.forgeeks.SpringDZ5.core.configs;

import org.springframework.context.annotation.*;
import org.springframework.web.client.RestTemplate;

@Configuration
//@PropertySource("secrets.properties")
//@EnableAspectJAutoProxy
//@ComponentScan("com.forgeeks.SpringDZ5")
public class AppConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


}
