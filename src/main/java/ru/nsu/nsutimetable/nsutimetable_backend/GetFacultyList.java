package ru.nsu.nsutimetable.nsutimetable_backend;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.FacultyList;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.Group;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class GetFacultyList {
    final private FacultyList facultyList;
    private static final String FILE_NAME = "/FIT_timetable.json";
//    private static final String FILE_NAME = "/table.json";


    public GetFacultyList() {
        FacultyList facultyList1;

        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = GetFacultyList.class.getResourceAsStream(FILE_NAME);
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
        return foreachGroupListWithReturn(groups -> groups.stream().filter(_group -> _group.getGroupNum().equals(groupNum))
                .findFirst()).orElseThrow(() -> new RuntimeException("Requested group does not exist"));
    }

    public List<Integer> getGroupNumList() {
        var groupNums = new ArrayList<Integer>();
        foreachGroupList(groups ->
                groupNums.addAll(groups.stream().map(Group::getGroupNum).toList())
        );
        return groupNums;
    }

    public <T> void foreachGroupList(Consumer<List<Group>> consumer) {
        foreachGroupListWithReturn(groups -> {
            consumer.accept(groups);
            return null;
        });
    }

    public <T> T foreachGroupListWithReturn(Function<List<Group>, T> function) {

        for (var faculty :
                getFacultyList().getFaculties())
            for (var degrees :
                    faculty.getDegrees())
                for (var course :
                        degrees.getCourses()) {
                    var res = function.apply(course.getGroups());
                    if (res != null) return res;
                }
        return null;
    }
}
