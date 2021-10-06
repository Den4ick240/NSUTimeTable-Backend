package ru.nsu.nsutimetable.nsutimetable_backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.nsu.nsutimetable.nsutimetable_backend.GetFacultyList;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.*;

import java.util.List;

@RestController
@RequestMapping(path = "api")
@CrossOrigin(origins = "http://localhost:3000")
public class Controller {
    private final GetFacultyList getFacultyList;

    @Autowired
    private GroupCache groupCache;

    public Controller(GetFacultyList getFacultyList) {
        this.getFacultyList = getFacultyList;
    }

    @GetMapping(path = "table")
    public Group getGroup() {
        return groupCache.getGroup();
    }

    @GetMapping(path = "table/{groupName}")
    public Group getGroup(@PathVariable Integer groupName) {
        return getFacultyList.findGroup(groupName);
    }

    @PostMapping(path = "table")
    public Group createTableFromGroup(@RequestBody SetGroupForm setGroupForm) {
        groupCache.setGroup(getFacultyList.findGroup(setGroupForm.getGroupNum()));
        return groupCache.getGroup();
    }

    @PostMapping(path = "table/")
    public void addSubject(@RequestBody AddSubjectFrom subject){
        groupCache.addSubject(subject.getDayNum(), subject.getSubject());
    }

    @DeleteMapping(path = "table")
    public void deleteSubject(@RequestBody RemoveSubjectForm removeSubjectForm) {
        groupCache.removeSubject(removeSubjectForm);
    }

    @GetMapping(path = "group_num_list")
    public List<Integer> getGroupNumList() {
        return getFacultyList.getGroupNumList();
    }
}
