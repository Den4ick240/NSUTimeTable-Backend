
package ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.faculty_schedules;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Table {
    private Integer dayNum;
    private List<Subject> subjects = null;
}
