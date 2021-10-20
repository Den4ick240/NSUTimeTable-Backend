package ru.nsu.nsutimetable.nsutimetable_backend.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.faculty_schedules.FacultySchedules;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.spec.SpecCourses;

import java.io.IOException;
import java.io.InputStream;

@Service
@Scope("singleton")
public class SpecCoursesServiceFromFile implements SpecCoursesService {

    private static final String FILE_NAME = "/spec.json";

    private final SpecCourses specCourses;

    public SpecCoursesServiceFromFile() {
        SpecCourses specCourses1;
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = GroupServiceFromFacultyList.class.getResourceAsStream(FILE_NAME);
            specCourses1 = mapper.readValue(is, SpecCourses.class);
        } catch (IOException e) {
            e.printStackTrace();
            specCourses1 = null;
        }
        specCourses = specCourses1;
    }

    @Override
    public SpecCourses getSpecCourses() {
        return specCourses;
    }
}
