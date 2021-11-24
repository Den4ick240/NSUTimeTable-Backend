
package ru.nsu.nsutimetable.nsutimetable_backend.domain.spec;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private Integer num;
    private List<Subject> subjects = null;
}
