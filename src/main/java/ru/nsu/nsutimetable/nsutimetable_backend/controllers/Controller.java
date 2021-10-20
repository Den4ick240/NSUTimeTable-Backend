package ru.nsu.nsutimetable.nsutimetable_backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.nsu.nsutimetable.nsutimetable_backend.service.GroupService;
import ru.nsu.nsutimetable.nsutimetable_backend.service.GroupServiceFromFacultyList;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.api_forms.AddSubjectFrom;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.api_forms.RemoveSubjectForm;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.api_forms.SetGroupForm;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.faculty_schedules.Group;

import java.util.List;

@RestController
@RequestMapping(path = "api")
@CrossOrigin(origins = "http://localhost:3000")
public class Controller {
    private final GroupService getFacultyList;
    private final GroupCache groupCache;

    public Controller(GroupServiceFromFacultyList getFacultyList, GroupCache groupCache) {
        this.getFacultyList = getFacultyList;
        this.groupCache = groupCache;
    }

    @GetMapping(path = "table")
    public Group getGroup() {
        return groupCache.getGroup();
    }

    @GetMapping(path = "table/{groupName}")
    public Group getGroup(@PathVariable String groupName) {
        return getFacultyList.findGroupByGroupNum(groupName);
    }

    @PostMapping(path = "table")
    public Group createTableFromGroup(@RequestBody SetGroupForm setGroupForm) {
        groupCache.setGroup(getFacultyList.findGroupByGroupNum(setGroupForm.getGroupNum()));
        return groupCache.getGroup();
    }

    @PutMapping(path = "table")
    public void addSubject(@RequestBody AddSubjectFrom addSubjectFrom){
        groupCache.addSubject(addSubjectFrom.getDayNum(), addSubjectFrom.getSubject());
    }

    @DeleteMapping(path = "table")
    public void deleteSubject(@RequestBody RemoveSubjectForm removeSubjectForm) {
        groupCache.removeSubject(removeSubjectForm);
    }

    @GetMapping(path = "group_num_list")
    public List<String> getGroupNumList() {
        return getFacultyList.getGroupNumList();
    }
}
