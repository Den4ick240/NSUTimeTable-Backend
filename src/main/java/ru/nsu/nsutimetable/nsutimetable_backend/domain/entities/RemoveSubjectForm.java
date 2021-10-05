package ru.nsu.nsutimetable.nsutimetable_backend.domain.entities;

import java.util.Objects;

public class RemoveSubjectForm {
    private Integer dayNum;
    private String odd;
    private Integer lessonNum;
    private String name;

    public RemoveSubjectForm() {
    }

    public RemoveSubjectForm(Integer dayNum, String odd, Integer lessonNum, String name) {
        this.dayNum = dayNum;
        this.odd = odd;
        this.lessonNum = lessonNum;
        this.name = name;
    }

    public Integer getDayNum() {
        return dayNum;
    }

    public void setDayNum(Integer dayNum) {
        this.dayNum = dayNum;
    }

    public String getOdd() {
        return odd;
    }

    public void setOdd(String odd) {
        this.odd = odd;
    }

    public Integer getLessonNum() {
        return lessonNum;
    }

    public void setLessonNum(Integer lessonNum) {
        this.lessonNum = lessonNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RemoveSubjectForm that = (RemoveSubjectForm) o;
        return Objects.equals(dayNum, that.dayNum) && Objects.equals(odd, that.odd) && Objects.equals(lessonNum, that.lessonNum) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dayNum, odd, lessonNum, name);
    }

    @Override
    public String toString() {
        return "RemoveSubjectForm{" +
                "dayNum=" + dayNum +
                ", odd='" + odd + '\'' +
                ", lessonNum=" + lessonNum +
                ", name='" + name + '\'' +
                '}';
    }
}
