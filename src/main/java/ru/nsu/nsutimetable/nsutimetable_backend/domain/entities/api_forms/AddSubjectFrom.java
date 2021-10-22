package ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.api_forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.faculty_schedules.Subject;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddSubjectFrom {
    private int dayNum;
    private Subject subject;
}
