package ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.api_forms;

public class SetGroupForm {
    private String groupNum;

    public SetGroupForm() {

    }

    public SetGroupForm(String groupNum) {
        this.groupNum = groupNum;
    }

    public String getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(String groupNum) {
        this.groupNum = groupNum;
    }
}
