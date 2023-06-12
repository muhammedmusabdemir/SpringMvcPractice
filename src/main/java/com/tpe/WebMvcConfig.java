package com.tpe;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc //mvc yapisinda calisilicak
@ComponentScan("com.tpe") //componentlarin taranip bean olusturmasini saglar
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean //Kullaniciya gorebilir hale getirebilmek icin viewResolver kullaniyoruz
    public InternalResourceViewResolver resolver() {
        InternalResourceViewResolver resolver=new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class); //daha az java kodu yazarak jsp dosyalari yazmaya yarar
        resolver.setPrefix("/WEB-INF/views/"); //bu dosyalarin nerde olacagi
        resolver.setSuffix(".jsp"); //java server page uzantili dosyalar kullan
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) { //css,style,image gibi dosylar icin yol
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/").setCachePeriod(0);
    }

}