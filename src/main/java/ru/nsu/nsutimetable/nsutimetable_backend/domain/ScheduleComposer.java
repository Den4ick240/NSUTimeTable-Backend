package ru.nsu.nsutimetable.nsutimetable_backend.domain;

import org.springframework.stereotype.Service;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.UserInfo;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.UserTable;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.faculty_schedules.Table;
import ru.nsu.nsutimetable.nsutimetable_backend.service.GroupService;
import ru.nsu.nsutimetable.nsutimetable_backend.service.SpecCoursesService;

import java.util.List;

@Service
public class ScheduleComposer {
    private final GroupService groupService;
    private final SpecCoursesService specCoursesService;

    public ScheduleComposer(GroupService groupService,
                            SpecCoursesService specCoursesService) {
        this.groupService = groupService;
        this.specCoursesService = specCoursesService;
    }

    public UserTable composeUserTable(UserInfo userInfo) {
        List<Table> table = groupService.findGroupByGroupNum(userInfo.getGroupNum()).getTable();
        return new UserTable(
                table
        );
    }
}
