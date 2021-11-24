package ru.nsu.nsutimetable.nsutimetable_backend.controllers;

import ru.nsu.nsutimetable.nsutimetable_backend.domain.faculty_schedules.Group;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.api_forms.RemoveSubjectForm;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.faculty_schedules.Subject;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.faculty_schedules.Table;

public class GroupCache {
    private Group group = null;

    public void addSubject(int dayNum, Subject subject) {
        getTable(dayNum).getSubjects().add(subject);
    }

    public void removeSubject(RemoveSubjectForm removeSubjectForm) {
        getTable(removeSubjectForm.getDayNum()).getSubjects().removeIf(
                subject ->
                        subject.getName().equals(removeSubjectForm.getName()) &&
                                subject.getLessonNum().equals(removeSubjectForm.getLessonNum()) &&
                                (
                                        subject.getOdd() == removeSubjectForm.getOdd() ||
                                                (
                                                        subject.getOdd() != null && removeSubjectForm.getOdd() != null && subject.getOdd().equals(removeSubjectForm.getOdd())
                                                )
                                )
        );
    }

    private Table getTable(int dayNum) {
        return group.getTable()
                .stream()
                .filter(table -> table.getDayNum().equals(dayNum))
                .findFirst()
                .orElseThrow(
                        () -> new RuntimeException("Trying to add subject to incorrect dayNum")
                );
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
