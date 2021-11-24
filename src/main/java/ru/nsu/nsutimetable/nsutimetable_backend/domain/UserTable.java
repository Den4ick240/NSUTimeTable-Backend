package ru.nsu.nsutimetable.nsutimetable_backend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.faculty_schedules.Table;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import javax.validation.Valid;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserTable {
    @TableList
    private List<@Valid Table> table = null;


    public @interface TableList {
        String message() default "{TableList.invalid}";
        Class<?>[] groups() default { };
        Class<? extends Payload>[] payload() default { };
    }

    class TableListValidator implements ConstraintValidator<TableList, List<Table>> {
        @Override
        public boolean isValid(List<Table> value, ConstraintValidatorContext context) {
            if (value.size() != 7) return false;
            for (int i = 1; i <= 7; i++) {
                Integer finalI = i;
                if (value.stream().filter(table -> finalI.equals(table.getDayNum())).count() != 1) return false;
            }
            return true;
        }
    }
}
