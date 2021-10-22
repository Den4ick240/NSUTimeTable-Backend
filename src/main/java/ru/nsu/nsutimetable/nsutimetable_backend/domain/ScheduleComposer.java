package ru.nsu.nsutimetable.nsutimetable_backend.domain;

import org.springframework.stereotype.Service;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.UserInfo;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.UserTable;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.faculty_schedules.Table;
import ru.nsu.nsutimetable.nsutimetable_backend.exception.TableException;
import ru.nsu.nsutimetable.nsutimetable_backend.service.GroupService;
import ru.nsu.nsutimetable.nsutimetable_backend.service.SpecSubjectService;

import java.util.List;

@Service
public class ScheduleComposer {
    private final GroupService groupService;
    private final SpecSubjectService specSubjectService;

    public ScheduleComposer(GroupService groupService,
                            SpecSubjectService specSubjectsService) {
        this.groupService = groupService;
        this.specSubjectService = specSubjectsService;
    }

    public UserTable composeUserTable(UserInfo userInfo) throws TableException {
        List<Table> table = groupService.findGroupByGroupNum(userInfo.getGroupNum()).getTable();

        var specSubjects = specSubjectService.findAllForGroupInfo(
                groupService.getGroupInfoByGroupNum(userInfo.getGroupNum())
        );

        table.forEach(day ->
                day.getSubjects()
                        .removeIf(
                                subject ->
                                        !subject.getOptional() ||
                                                specSubjects
                                                        .stream()
                                                        .filter(specSubject ->
                                                                specSubject.getFullName().equals(subject.getFullName())
                                                        )
                                                        .findFirst()
                                                        .map(specSubjectHasStudent -> specSubjectHasStudent
                                                                .getStudents()
                                                                .stream()
                                                                .noneMatch(student ->
                                                                        student.getName().equals(userInfo.getName())
                                                                )
                                                        )
                                                        .orElseGet(
                                                                () -> {
                                                                    System.out.println(
                                                                            "subject is optional but it was not found in specCourses list");
                                                                    return false;
                                                                }
                                                        )
                        )
        );

        return new UserTable(table);

    }
}
