package com.forgeeks.SpringDZ5.core.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("secrets.properties")
@EnableAspectJAutoProxy
@ComponentScan("com.forgeeks.SpringDZ5")
public class AppConfig {
}
