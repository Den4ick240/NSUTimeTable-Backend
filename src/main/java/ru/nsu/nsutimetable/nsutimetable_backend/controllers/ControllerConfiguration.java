package ru.nsu.nsutimetable.nsutimetable_backend.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.annotation.SessionScope;
import ru.nsu.nsutimetable.nsutimetable_backend.GetFacultyList;

@Configuration
public class ControllerConfiguration {
    @Bean
    public GetFacultyList getFacultyList() {
        return new GetFacultyList();
    }

    @Bean
    @SessionScope
    public GroupCache groupCache() {
        return new GroupCache();
    }
}
