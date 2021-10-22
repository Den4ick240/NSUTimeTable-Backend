
package ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.faculty_schedules;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacultySchedules {
    private List<Faculty> faculties = null;
}
