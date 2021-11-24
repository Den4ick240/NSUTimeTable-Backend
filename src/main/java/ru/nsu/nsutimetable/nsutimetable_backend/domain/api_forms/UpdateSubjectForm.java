package ru.nsu.nsutimetable.nsutimetable_backend.domain.api_forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSubjectForm {
    private RemoveSubjectForm oldSubject;
    private Integer dayNum;
    private Integer lessonNum;
    private String room;
}
