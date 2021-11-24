
package ru.nsu.nsutimetable.nsutimetable_backend.domain.spec;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subject {
    private String year;
    private String speciality;
    private String fullName;
    private String cathedra;
    private List<Student> students = null;
}
