package ru.nsu.nsutimetable.nsutimetable_backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.users.UserStudentInfo;

public interface UserStudentInfoRepository extends MongoRepository<UserStudentInfo, String> {
}
