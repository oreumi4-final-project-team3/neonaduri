package com.est.neonaduri.global.config;

import jakarta.servlet.MultipartConfigElement;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class ImageFileConfig {

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        DataSize MaxFileSize = DataSize.parse("10MB");
        factory.setMaxFileSize(MaxFileSize);
        factory.setMaxRequestSize(MaxFileSize);
        return factory.createMultipartConfig();
    }

    @Bean
    public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
        ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet);
        registration.addUrlMappings("/*");
        registration.setMultipartConfig(multipartConfigElement());
        return registration;
    }
}



