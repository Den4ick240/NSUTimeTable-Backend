package ru.nsu.nsutimetable.nsutimetable_backend;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {


    private final CorsHosts corsHosts;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        System.out.println(corsHosts.hosts[1]);
        registry.addMapping("/**")
                .allowedOrigins("http://51.137.91.161/", "http://localhost")
//                .allowedOrigins(corsHosts.hosts)
                .allowedMethods("*")
                .allowCredentials(true)
        ;
    }
}
