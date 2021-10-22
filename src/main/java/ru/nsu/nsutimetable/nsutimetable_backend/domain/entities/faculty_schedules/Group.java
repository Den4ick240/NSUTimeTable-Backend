
package ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.faculty_schedules;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Group {
    private String groupNum;
    private List<Table> table = null;
}
