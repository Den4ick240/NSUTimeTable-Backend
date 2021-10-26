package ru.nsu.nsutimetable.nsutimetable_backend.controllers;

import org.springframework.web.bind.annotation.*;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.ScheduleComposer;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.UserInfo;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.UserTable;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.api_forms.AddSubjectFrom;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.api_forms.RemoveSubjectForm;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.faculty_schedules.Group;
import ru.nsu.nsutimetable.nsutimetable_backend.exception.TableException;
import ru.nsu.nsutimetable.nsutimetable_backend.service.GroupService;
import ru.nsu.nsutimetable.nsutimetable_backend.service.GroupServiceFromFacultyList;
import ru.nsu.nsutimetable.nsutimetable_backend.service.UserTableService;

import java.util.List;

@RestController
@RequestMapping(path = "api")
@CrossOrigin(origins = "http://localhost:3000")
public class Controller {
    private final GroupService getFacultyList;
    private final UserTableService userTableService;
    private final ScheduleComposer scheduleComposer;

    public Controller(GroupServiceFromFacultyList getFacultyList,
                      UserTableService userTableService,
                      ScheduleComposer scheduleComposer) {
        this.getFacultyList = getFacultyList;
        this.userTableService = userTableService;
        this.scheduleComposer = scheduleComposer;
    }

    @GetMapping(path = "table")
    public UserTable getGroup() {
        return userTableService.getUserTable();
    }

    @GetMapping(path = "table/{groupName}")
    public Group getGroup(@PathVariable String groupName) throws TableException {
        return getFacultyList.findGroupByGroupNum(groupName);
    }

    @PostMapping(path = "table")
    public UserTable createTableFromGroup(@RequestBody UserInfo userInfo) throws TableException {
//        try {
            userTableService.setUserTable(scheduleComposer.composeUserTable(userInfo));
//        } catch (TableException e) {
//            e.printStackTrace();
//        }
        return userTableService.getUserTable();
    }

    @PutMapping(path = "table")
    public void addSubject(@RequestBody AddSubjectFrom addSubjectFrom){
        try {
            userTableService.addSubject(addSubjectFrom);
        } catch (TableException e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping(path = "table")
    public void deleteSubject(@RequestBody RemoveSubjectForm removeSubjectForm) {
        try {
            userTableService.removeSubject(removeSubjectForm);
        } catch (TableException e) {
            e.printStackTrace();
        }
    }

    @GetMapping(path = "group_num_list")
    public List<String> getGroupNumList() {
        return getFacultyList.getGroupNumList();
    }
}
