package ru.nsu.nsutimetable.nsutimetable_backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.GroupInfo;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.faculty_schedules.Group;
import ru.nsu.nsutimetable.nsutimetable_backend.exception.TableException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

@Service
@SessionScope
@RequiredArgsConstructor
public class GroupServiceFromFacultyList implements GroupService {
    private final FacultyTablesService facultyTablesService;

    @Override
    public Group findGroupByGroupNum(String groupNum) throws TableException {

        return Optional
                .ofNullable(
                        foreachGroupListWithReturn(
                                groups -> groups
                                        .stream()
                                        .filter(_group -> _group.getGroupNum().equals(groupNum))
                                        .findFirst()
                                        .orElse(null))
                )
                .map(group -> new Group(group.getGroupNum(), new ArrayList<>(group.getTable())))
                .orElseThrow(() -> new TableException("Requested group does not exist"));
    }

    @Override
    public List<String> getGroupNumList() {
        var groupNums = new ArrayList<String>();
        foreachGroupList(groups ->
                groupNums.addAll(groups.stream().map(Group::getGroupNum).toList())
        );
        return groupNums;
    }

    @Override
    public GroupInfo getGroupInfoByGroupNum(String groupNum) throws TableException {
        for (var faculty : facultyTablesService.getFacultyTables().getFaculties())
            for (var degree : faculty.getDegrees())
                for (var course : degree.getCourses())
                    if (course.getGroups().stream().anyMatch(group -> group.getGroupNum().equals(groupNum)))
                        return new GroupInfo(groupNum, course.getNum(), degree.getName(), faculty.getName());
        throw new TableException("requested group does not exist");
    }

    private <T> void foreachGroupList(Consumer<List<Group>> consumer) {
        foreachGroupListWithReturn(groups -> {
            consumer.accept(groups);
            return null;
        });
    }

    private <T> T foreachGroupListWithReturn(Function<List<Group>, T> function) {

        for (var faculty :
                facultyTablesService.getFacultyTables().getFaculties())
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
