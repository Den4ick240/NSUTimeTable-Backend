package ru.nsu.nsutimetable.nsutimetable_backend.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.faculty_schedules.FacultySchedules;

import java.io.IOException;
import java.io.InputStream;

@Service
public class FacultyScheduleServiceFromFile implements FacultySchedulesService {
    private static final String FILE_NAME = "/FIT_timetable.json";

    private final FacultySchedules facultySchedules;

    public FacultyScheduleServiceFromFile() {
        FacultySchedules facultyList1;

        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = GroupServiceFromFacultyList.class.getResourceAsStream(FILE_NAME);
            facultyList1 = mapper.readValue(is, FacultySchedules.class);
        } catch (IOException e) {
            e.printStackTrace();
            facultyList1 = null;
        }
        facultySchedules = facultyList1;
    }

    @Override
    public FacultySchedules getFacultySchedules() {
        return facultySchedules;
    }
}
