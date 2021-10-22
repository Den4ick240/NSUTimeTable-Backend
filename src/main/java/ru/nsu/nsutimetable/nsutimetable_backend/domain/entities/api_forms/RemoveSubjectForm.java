package ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.api_forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RemoveSubjectForm {
    private Integer dayNum;
    private String odd;
    private Integer lessonNum;
    private String name;
}
