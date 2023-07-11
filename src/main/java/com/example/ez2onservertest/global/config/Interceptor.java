package com.example.ez2onservertest.global.config;


import com.example.ez2onservertest.global.Intercepter.LoginLogger;
import com.example.ez2onservertest.global.Intercepter.MainLogger;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Interceptor implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        /* MainController Logger */

        registry.addInterceptor(new MainLogger())
                .order(1)
                .addPathPatterns("/");



        /* LoginController Logger */

        registry.addInterceptor(new LoginLogger())
                .order(2)
                .addPathPatterns("/login");

    }
}
