package ru.nsu.nsutimetable.nsutimetable_backend.controllers;

import org.springframework.web.bind.annotation.*;
import ru.nsu.nsutimetable.nsutimetable_backend.GetFacultyList;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.Group;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.RemoveSubjectForm;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.Subject;

import java.util.List;

@RestController
@RequestMapping(path = "api")
public class Controller {
    private final GetFacultyList getFacultyList;

    private final GroupCache groupCache;

    public Controller(GetFacultyList getFacultyList, GroupCache groupCache) {
        this.getFacultyList = getFacultyList;
        this.groupCache = groupCache;
    }

    @GetMapping(path = "table")
    public Group getGroup() {
        return groupCache.getGroup();
    }

    @PostMapping(path = "table/{groupName}")
    public Group createTableFromGroup(@PathVariable Integer groupName) {
        groupCache.setGroup(getFacultyList.findGroup(groupName));
        return groupCache.getGroup();
    }

    @PostMapping(path = "table/{dayNum}")
    public void addSubject(@PathVariable Integer dayNum, @RequestBody Subject subject){
        groupCache.addSubject(dayNum, subject);
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
