package com.tpe;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override //db ve hibernate ile ilgili configurationlar
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {
                RootContextConfig.class
        };
    }

    @Override //Spring MVC config ayarlari - bean tanimlamalarinin yer aldigi class
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {
                WebMvcConfig.class
        };
    }

    @Override //hangi url hangi servlet ile iliskilendirilecek
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }



}