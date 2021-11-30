package ru.nsu.nsutimetable.nsutimetable_backend.service;

import ru.nsu.nsutimetable.nsutimetable_backend.domain.StudentInfo;

public interface UserStudentInfoService {
    StudentInfo getStudentInfo(String username);
    StudentInfo setStudentInfo(String username, StudentInfo studentInfo);
}
