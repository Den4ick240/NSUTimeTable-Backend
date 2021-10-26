package ru.nsu.nsutimetable.nsutimetable_backend.service;

import ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.GroupInfo;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.spec.Subject;

import java.util.List;

public interface SpecSubjectService {
    List<Subject> findAllForGroupInfo(GroupInfo groupInfo);
}
