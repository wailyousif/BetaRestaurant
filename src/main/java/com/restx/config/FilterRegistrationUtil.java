package com.restx.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Created by wailm.yousif on 2/7/17.
 */
@Configuration
public class FilterRegistrationUtil {

    @Autowired
    private Environment env;

    @Bean
    public FilterRegistrationBean mvcSecutiryFilter()
    {
        FilterRegistrationBean registration = new FilterRegistrationBean(new AuthFilter(env));

        //registration.addUrlPatterns("/*");
        registration.addUrlPatterns("/mvc/*");
        registration.addUrlPatterns("/rest/*");
        registration.addUrlPatterns("/pages/secure/*");

        return registration;
    }
}