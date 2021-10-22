package ru.nsu.nsutimetable.nsutimetable_backend.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.faculty_schedules.Table;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserTable {
    private List<Table> table = null;
}
