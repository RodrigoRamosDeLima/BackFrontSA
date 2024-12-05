package com.senai.liquidsa.config;

import com.senai.liquidsa.controllers.InterceptorController;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final InterceptorController interceptorController;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
                .addInterceptor(interceptorController)
                .excludePathPatterns(
                        "/login",
                        "/usuarios/cadastro"
                );
    }
}
