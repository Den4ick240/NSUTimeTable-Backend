package ru.nsu.nsutimetable.nsutimetable_backend.domain.entities;

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
