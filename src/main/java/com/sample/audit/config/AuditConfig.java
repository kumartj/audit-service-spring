package com.sample.audit.config;

import com.sample.audit.AuditInterceptor;
import com.sample.audit.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AuditConfig implements WebMvcConfigurer {

    @Autowired
    private AuditService auditService;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(auditInterceptor(auditService));
    }

    private static AuditInterceptor auditInterceptor(AuditService auditService) {
        return new AuditInterceptor(auditService);
    }
}
