package com.sw.guestbook.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class GuestBookConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry ) {
    	corsRegistry.addMapping("/**")
          .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS"); // this must be configured because if not given, by default only GET and POST are considered for CORS

    }

}
