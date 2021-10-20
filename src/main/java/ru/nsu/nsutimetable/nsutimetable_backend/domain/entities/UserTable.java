package ru.nsu.nsutimetable.nsutimetable_backend.domain.entities;

import ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.faculty_schedules.Table;

import java.util.List;
import java.util.Objects;

public class UserTable {
    private List<Table> table = null;

    public UserTable() {
    }

    public UserTable(List<Table> table) {
        this.table = table;
    }

    public List<Table> getTable() {
        return table;
    }

    public void setTable(List<Table> table) {
        this.table = table;
    }

    @Override
    public String toString() {
        return "UserSchedule{" +
                "table=" + table +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserTable that = (UserTable) o;
        return Objects.equals(table, that.table);
    }

    @Override
    public int hashCode() {
        return Objects.hash(table);
    }
}
