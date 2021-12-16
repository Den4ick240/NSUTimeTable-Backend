package ru.nsu.nsutimetable.nsutimetable_backend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CorsHosts {

    @Value("${corshosts}")
    public String[] hosts;
}
