
package ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.faculty_schedules;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Table {
    @NotNull
    private Integer dayNum;
    private List<@Valid Subject> subjects = null;
}
