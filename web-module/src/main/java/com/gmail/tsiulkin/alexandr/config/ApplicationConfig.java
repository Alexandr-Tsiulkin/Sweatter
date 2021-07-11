package com.gmail.tsiulkin.alexandr.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.gmail.tsiulkin.alexandr.repository", "com.gmail.tsiulkin.alexandr.service"})
public class ApplicationConfig {
}
