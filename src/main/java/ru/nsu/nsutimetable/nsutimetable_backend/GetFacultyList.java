package ru.nsu.nsutimetable.nsutimetable_backend;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.FacultyList;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.Group;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class GetFacultyList {
    final private FacultyList facultyList;


    public GetFacultyList() {
        FacultyList facultyList1;

        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = GetFacultyList.class.getResourceAsStream("/table.json");
            facultyList1 = mapper.readValue(is, FacultyList.class);
        } catch (IOException e) {
            e.printStackTrace();
            facultyList1 = null;
        }
        facultyList = facultyList1;
    }

    public FacultyList getFacultyList() {
        return facultyList;
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

    public List<Integer> getGroupNumList() {
        var groupNums = new ArrayList<Integer>();
        for (var faculty : getFacultyList().getFaculties()) {
            for (var course : faculty.getCourses()) {
                groupNums.addAll(course.getGroups().stream().map(Group::getGroupNum).toList());
            }
        }
        return groupNums;
    }
}
