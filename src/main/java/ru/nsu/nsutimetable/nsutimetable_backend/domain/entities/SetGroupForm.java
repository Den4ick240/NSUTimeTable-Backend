package ru.nsu.nsutimetable.nsutimetable_backend.domain.entities;

public class SetGroupForm {
    private Integer groupNum;

    public SetGroupForm() {

    }

    public SetGroupForm(Integer groupNum) {
        this.groupNum = groupNum;
    }

    public Integer getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(Integer groupNum) {
        this.groupNum = groupNum;
    }
}
