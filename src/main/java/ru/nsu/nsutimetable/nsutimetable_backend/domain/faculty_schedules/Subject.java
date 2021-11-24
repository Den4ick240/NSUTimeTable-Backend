
package ru.nsu.nsutimetable.nsutimetable_backend.domain.faculty_schedules;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subject {
    @Min(1)
    @Max(7)
    @NotNull
    private Integer lessonNum;

    @NotNull
    @NotEmpty
    private String name;
    private String fullName;
    private Object odd;
    private String type;
    private String room;
    private String teacher;
    private Boolean optional;
}
