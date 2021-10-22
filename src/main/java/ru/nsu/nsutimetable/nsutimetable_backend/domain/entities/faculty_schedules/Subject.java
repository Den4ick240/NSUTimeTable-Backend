
package ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.faculty_schedules;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subject {
    private Integer lessonNum;
    private String name;
    private String fullName;
    private Object odd;
    private String type;
    private String room;
    private String teacher;
    private Boolean optional;
}
