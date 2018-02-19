package com.sandeep.guestbook.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created with IntelliJ IDEA.
 * User: swadhwa6
 * Date: 2/18/18
 * Time: 12:05 PM
 * To change this template use File | Settings | File Templates.
 */

@Configuration
public class GuestBookConfiguration {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry aRegistry) {
                aRegistry.addMapping("/**")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS"); // this must be configured because if not given, by default only GET and POST are considered for CORS
            }
        };
    }

}
