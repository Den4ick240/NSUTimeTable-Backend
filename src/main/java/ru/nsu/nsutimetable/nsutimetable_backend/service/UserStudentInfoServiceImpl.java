package ru.nsu.nsutimetable.nsutimetable_backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.StudentInfo;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.users.UserStudentInfo;
import ru.nsu.nsutimetable.nsutimetable_backend.repository.UserStudentInfoRepository;

@RequiredArgsConstructor
@Service
public class UserStudentInfoServiceImpl implements UserStudentInfoService {
    private final UserStudentInfoRepository repository;

    @Override
    public StudentInfo getStudentInfo(String username) {
        return repository
                .findById(username)
                .map(UserStudentInfo::getStudentInfo)
                .get();
    }

    @Override
    public StudentInfo setStudentInfo(String username, StudentInfo studentInfo) {
        repository.save(new UserStudentInfo(username, studentInfo));
        return studentInfo;
    }
}
