package com.gdufs.vietnameselearning.config;

import com.gdufs.vietnameselearning.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringbootConfig implements WebMvcConfigurer {
    //请求拦截配置
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/","/login","/checkCode","/login/*",
                        "/phoneCode/*","/register","/getimg","/uploadimg/*","/error");
    }

    //静态资源处理
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/uploadimg/**")
                .addResourceLocations("file:"+System.getProperty("user.dir")+"/src/main/resources/static/uploadImg/");
    }




}
