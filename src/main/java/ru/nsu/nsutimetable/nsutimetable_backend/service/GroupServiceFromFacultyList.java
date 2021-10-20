package ru.nsu.nsutimetable.nsutimetable_backend.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.faculty_schedules.FacultySchedules;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.faculty_schedules.Group;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

@Service
public class GroupServiceFromFacultyList implements GroupService {
    final private FacultySchedules facultyList;

    public GroupServiceFromFacultyList(FacultySchedulesService facultySchedulesService) {
        this.facultyList = facultySchedulesService.getFacultySchedules();
    }

    public Group findGroupByGroupNum(String groupNum) {

        return Optional
                .ofNullable(
                        foreachGroupListWithReturn(
                                groups -> groups
                                        .stream()
                                        .filter(_group -> _group.getGroupNum().equals(groupNum))
                                        .findFirst()
                                        .orElse(null))
                )
                .orElseThrow(() -> new RuntimeException("Requested group does not exist"));
    }

    public List<String> getGroupNumList() {
        var groupNums = new ArrayList<String>();
        foreachGroupList(groups ->
                groupNums.addAll(groups.stream().map(Group::getGroupNum).toList())
        );
        return groupNums;
    }

    private <T> void foreachGroupList(Consumer<List<Group>> consumer) {
        foreachGroupListWithReturn(groups -> {
            consumer.accept(groups);
            return null;
        });
    }

    private <T> T foreachGroupListWithReturn(Function<List<Group>, T> function) {

        for (var faculty :
                facultyList.getFaculties())
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
