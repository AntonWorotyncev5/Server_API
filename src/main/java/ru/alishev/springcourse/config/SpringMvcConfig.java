package ru.alishev.springcourse.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.MultipartConfigElement;

@Configuration
@ComponentScan
@EnableAutoConfiguration

public class SpringMvcConfig implements WebMvcConfigurer {

    @Value( "${upload.path}")
    private String uploadPath;

    @Value( "${patterns.patch.images}")
    private  String patternsImages;

    @Bean
    MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(DataSize.parse("5MB"));
        factory.setMaxRequestSize(DataSize.parse("5MB"));
        return  factory.createMultipartConfig();
    }

    @Override // настройка загрузки картинок
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler(patternsImages + "**").addResourceLocations("file://"+ uploadPath+"/");
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");


    }
}
