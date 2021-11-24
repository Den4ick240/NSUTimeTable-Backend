package ru.nsu.nsutimetable.nsutimetable_backend.service;

import ru.nsu.nsutimetable.nsutimetable_backend.domain.GroupInfo;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.faculty_schedules.Group;
import ru.nsu.nsutimetable.nsutimetable_backend.exception.TableException;

import java.util.List;

public interface GroupService {
    Group findGroupByGroupNum(String groupNum) throws TableException;

    List<String> getGroupNumList();

    GroupInfo getGroupInfoByGroupNum(String groupNum) throws TableException;
}
