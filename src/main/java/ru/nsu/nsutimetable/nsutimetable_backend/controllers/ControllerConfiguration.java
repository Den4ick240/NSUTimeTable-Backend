package ru.nsu.nsutimetable.nsutimetable_backend.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;
import ru.nsu.nsutimetable.nsutimetable_backend.service.GroupServiceFromFacultyList;

@Configuration
public class ControllerConfiguration {
    @Bean
    @SessionScope
    public GroupCache groupCache() {
        return new GroupCache();
    }
}
