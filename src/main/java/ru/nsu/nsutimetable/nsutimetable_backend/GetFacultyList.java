package ru.nsu.nsutimetable.nsutimetable_backend;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.FacultyList;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.Group;

import java.io.IOException;
import java.io.InputStream;

public class GetFacultyList {
    public FacultyList getFacultyList() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = GetFacultyList.class.getResourceAsStream("/table.json");
            return mapper.readValue(is, FacultyList.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Group findGroup(Integer groupNum) {
        for (var faculty :
                getFacultyList().getFaculties()) {
            for (var course :
                    faculty.getCourses()) {
                var group = course.getGroups()
                        .stream().filter(_group -> _group.getGroupNum().equals(groupNum))
                        .findFirst();
                if (group.isPresent()) return group.get();
            }
        }
        throw new RuntimeException("Requested group does not exist");
    }
}
