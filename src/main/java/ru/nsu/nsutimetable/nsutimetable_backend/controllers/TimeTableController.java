package ru.nsu.nsutimetable.nsutimetable_backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.ScheduleComposer;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.StudentInfo;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.UserTable;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.api_forms.AddSubjectFrom;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.api_forms.RemoveSubjectForm;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.api_forms.UpdateSubjectForm;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.faculty_schedules.Group;
import ru.nsu.nsutimetable.nsutimetable_backend.exception.TableException;
import ru.nsu.nsutimetable.nsutimetable_backend.service.GroupService;
import ru.nsu.nsutimetable.nsutimetable_backend.service.GroupServiceFromFacultyList;
import ru.nsu.nsutimetable.nsutimetable_backend.service.UserTableService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api")
@CrossOrigin(origins = "${corshosts}")
public class TimeTableController {
    private final GroupService getFacultyList;
    private final UserTableService userTableService;
    private final ScheduleComposer scheduleComposer;

    public TimeTableController(GroupServiceFromFacultyList getFacultyList,
                               UserTableService userTableService,
                               ScheduleComposer scheduleComposer) {
        this.getFacultyList = getFacultyList;
        this.userTableService = userTableService;
        this.scheduleComposer = scheduleComposer;
    }

    @PostMapping("logout")
    public void logout() {
        userTableService.setUserTable(null);
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
    public ResponseEntity<UserTable> createTableFromGroup(@RequestBody StudentInfo userInfo) {
        try {
            userTableService.setUserTable(
                    scheduleComposer.composeUserTable(userInfo)
            );
        } catch (TableException e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(
                userTableService.getUserTable()
        );
    }

    @PutMapping(path = "table")
    public void setUserTable(@Valid @RequestBody UserTable table) {
        userTableService.setUserTable(table);
    }

    @PostMapping(path = "table/subject")
    public void addSubject(@RequestBody AddSubjectFrom addSubjectFrom) throws TableException {
        userTableService.addSubject(addSubjectFrom);
    }

    @DeleteMapping(path = "table/subject")
    public void deleteSubject(@RequestBody RemoveSubjectForm removeSubjectForm) throws TableException {
        userTableService.removeSubject(removeSubjectForm);
    }

    @PutMapping(path = "table/subject")
    public void updateSubject(@RequestBody UpdateSubjectForm updateSubjectForm) throws TableException {
        userTableService.updateSubject(updateSubjectForm);
    }

    @GetMapping(path = "group_num_list")
    public List<String> getGroupNumList() {
        return getFacultyList.getGroupNumList();
    }
}
