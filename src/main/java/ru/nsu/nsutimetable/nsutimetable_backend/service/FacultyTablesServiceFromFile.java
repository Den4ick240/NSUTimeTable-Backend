package ru.nsu.nsutimetable.nsutimetable_backend.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.faculty_schedules.FacultyTables;

import java.io.IOException;
import java.io.InputStream;

@Service
@Scope("singleton")
public class FacultyTablesServiceFromFile implements FacultyTablesService {
    private static final String FILE_NAME = "/FIT_timetable.json";

    private final FacultyTables facultyTables;

    public FacultyTablesServiceFromFile() {
        FacultyTables facultyList1;

        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = GroupServiceFromFacultyList.class.getResourceAsStream(FILE_NAME);
            facultyList1 = mapper.readValue(is, FacultyTables.class);
        } catch (IOException e) {
            e.printStackTrace();
            facultyList1 = null;
        }
        facultyTables = facultyList1;
    }

    @Override
    public FacultyTables getFacultyTables() {
        return facultyTables;
    }
}
