package ru.nsu.nsutimetable.nsutimetable_backend.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupInfo {
    private String groupNum = null;
    private Integer courseNum = null;
    private String degree = null;
    private String faculty = null;
}
