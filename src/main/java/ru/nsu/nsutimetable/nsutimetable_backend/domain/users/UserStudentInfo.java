package ru.nsu.nsutimetable.nsutimetable_backend.domain.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.StudentInfo;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserStudentInfo {
    @Id
    private String username;

    private StudentInfo studentInfo;
}
