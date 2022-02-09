//package com.example.demo
//
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
//import org.springframework.context.annotation.Configuration
//import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer
//import org.springframework.web.servlet.config.annotation.CorsRegistry
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
//
//@Configuration
//@WebMvcConfigurer
//@ConditionalOnProperty("spring.application.develop", havingValue = "true")
//class CorsConfig{
//    void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedMethods("GET", "POST", "PUT", "OPTIONS", "DELETE", "PATCH")
//                .allowedOriginPatterns("http://localhost:3000", "https://colaba.space", frontendMainPage.toString())
//    }
//
//}
