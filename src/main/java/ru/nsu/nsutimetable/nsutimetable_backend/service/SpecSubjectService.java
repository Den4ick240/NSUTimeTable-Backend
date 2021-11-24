package ru.nsu.nsutimetable.nsutimetable_backend.service;

import ru.nsu.nsutimetable.nsutimetable_backend.domain.GroupInfo;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.spec.Subject;

import java.util.List;

public interface SpecSubjectService {
    List<Subject> findAllForGroupInfo(GroupInfo groupInfo);
}
