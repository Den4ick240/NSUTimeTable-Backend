package ru.nsu.nsutimetable.nsutimetable_backend.domain.api_forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SetGroupForm {
    private String groupNum;
}
