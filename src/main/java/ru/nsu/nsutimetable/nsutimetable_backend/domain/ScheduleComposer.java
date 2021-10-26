package ru.nsu.nsutimetable.nsutimetable_backend.domain;

import org.springframework.stereotype.Service;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.UserInfo;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.UserTable;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.faculty_schedules.Table;
import ru.nsu.nsutimetable.nsutimetable_backend.exception.TableException;
import ru.nsu.nsutimetable.nsutimetable_backend.service.GroupService;
import ru.nsu.nsutimetable.nsutimetable_backend.service.SpecSubjectService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        List<Table> table = new ArrayList<>(groupService.findGroupByGroupNum(userInfo.getGroupNum()).getTable());

        var specSubjects = specSubjectService.findAllForGroupInfo(
                groupService.getGroupInfoByGroupNum(userInfo.getGroupNum())
        );

        table = table.stream().map(day ->
                new Table(day.getDayNum(), day.getSubjects()
                        .stream().filter(
                                subject ->
                                        !subject.getOptional()
                                                ||
                                                specSubjects
                                                        .stream()
                                                        .filter(specSubject ->
                                                                specSubject.getFullName().equals(subject.getFullName())
                                                        )
                                                        .findFirst()
                                                        .map(specSubjectHasStudent -> specSubjectHasStudent
                                                                .getStudents()
                                                                .stream()
                                                                .anyMatch(student ->
                                                                        student.getName().equals(userInfo.getName())
                                                                )
                                                        )
                                                        .orElseGet(
                                                                () -> {
                                                                    System.out.println(
                                                                            "subject is optional but it was not found in specCourses list");
                                                                    return true;
                                                                }
                                                        )

                        ).collect(Collectors.toList()))
        ).collect(Collectors.toList());

        return new UserTable(table);
    }
}
