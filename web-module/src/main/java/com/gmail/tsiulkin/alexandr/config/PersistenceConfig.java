package com.gmail.tsiulkin.alexandr.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan("com.gmail.tsiulkin.alexandr.repository.model")
public class PersistenceConfig {
}
