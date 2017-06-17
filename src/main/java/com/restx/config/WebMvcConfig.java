package com.restx.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by wailm.yousif on 6/14/17.
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter
{
    //@Autowired
    //HandlerInterceptor tenantInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(tenantInterceptor);
        registry.addInterceptor(new TenantInterceptor());
    }
}
