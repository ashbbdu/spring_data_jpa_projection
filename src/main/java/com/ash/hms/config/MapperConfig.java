package com.ash.hms.config;


import com.ash.hms.auth.AuditorAwareImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "getAuditAwareImpl")
public class MapperConfig {
    @Bean
    public ModelMapper getModelMapper () {
        return new ModelMapper();
    }
//    rename the whole class , since this is holding configs other than ModelMapper
    @Bean
    public AuditorAware<String> getAuditAwareImpl () {
        return new AuditorAwareImpl();
    }
}


