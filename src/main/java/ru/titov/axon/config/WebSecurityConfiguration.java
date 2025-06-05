package ru.titov.axon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.titov.axon.handler.RequestContextFillingFilter;

@Configuration
public class WebSecurityConfiguration {

    @Bean
    public RequestContextFillingFilter.RequestContext requestContext() {
        return new RequestContextFillingFilter.RequestContext();
    }
 }
