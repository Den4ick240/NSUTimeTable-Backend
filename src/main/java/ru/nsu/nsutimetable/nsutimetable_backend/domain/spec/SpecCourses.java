
package ru.nsu.nsutimetable.nsutimetable_backend.domain.spec;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpecCourses {
    private List<Faculty> faculties = null;
}
