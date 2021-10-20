package ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.api_forms;

import ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.faculty_schedules.Subject;

public class AddSubjectFrom {
    private int dayNum;
    private Subject subject;

    public AddSubjectFrom() {

    }

    public AddSubjectFrom(int dayNum, Subject subject) {
        this.dayNum = dayNum;
        this.subject = subject;
    }

    public int getDayNum() {
        return dayNum;
    }

    public void setDayNum(int dayNum) {
        this.dayNum = dayNum;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
