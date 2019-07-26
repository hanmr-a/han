package com.fh.shop.brand.config;


import com.fh.shop.brand.intercepter.InfoIntercepter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfigurer extends WebMvcConfigurerAdapter {

    @Autowired
    private InfoIntercepter infoIntercepter;

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(infoIntercepter)
                .addPathPatterns("/**");
    }
}
