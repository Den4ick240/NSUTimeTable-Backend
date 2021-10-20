package ru.nsu.nsutimetable.nsutimetable_backend.service;

import ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.UserTable;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.api_forms.AddSubjectFrom;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.api_forms.RemoveSubjectForm;
import ru.nsu.nsutimetable.nsutimetable_backend.exception.TableException;

public interface UserTableService {
    UserTable getUserTable();
    void setUserTable(UserTable userSchedule);
    void addSubject(AddSubjectFrom addSubjectFrom) throws TableException;
    void removeSubject(RemoveSubjectForm removeSubjectForm) throws TableException;
}
