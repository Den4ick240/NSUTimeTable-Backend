package ru.nsu.nsutimetable.nsutimetable_backend.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.faculty_schedules.FacultyTables;

import java.io.IOException;
import java.io.InputStream;

@Service
@SessionScope
public class FacultyTablesServiceFromFile implements FacultyTablesService {
    private static final String FILE_NAME = "/FIT_table.json";

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
