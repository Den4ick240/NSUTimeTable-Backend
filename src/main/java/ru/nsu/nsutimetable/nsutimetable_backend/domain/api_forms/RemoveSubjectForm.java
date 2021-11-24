package ru.nsu.nsutimetable.nsutimetable_backend.domain.api_forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.faculty_schedules.Subject;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RemoveSubjectForm {
    private Integer dayNum;
    private String odd;
    private Integer lessonNum;
    private String name;

    public boolean subjectMatches(Subject subject) {
        return subject.getName().equals(name) &&
                subject.getLessonNum().equals(lessonNum) &&
                Objects.equals(subject.getOdd(), odd);
    }
}
