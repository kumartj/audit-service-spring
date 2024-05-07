package com.sample.audit.config;

import com.sample.audit.AuditService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@Configuration
public class AuditServiceAsyncConfig {

    @Bean
    public AuditService auditService() {
        return new AuditService();
    }
}
