package ru.nsu.nsutimetable.nsutimetable_backend.domain.api_forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.faculty_schedules.Subject;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddSubjectFrom {
    private int dayNum;
    private Subject subject;
}
