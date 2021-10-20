package ru.nsu.nsutimetable.nsutimetable_backend.domain.entities;

import java.util.Objects;

public class UserInfo {
    private String name;
    private String groupNum;

    public UserInfo() {}

    public UserInfo(String name, String groupNum) {
        this.name = name;
        this.groupNum = groupNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(String groupNum) {
        this.groupNum = groupNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return Objects.equals(name, userInfo.name) && Objects.equals(groupNum, userInfo.groupNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, groupNum);
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", groupNum='" + groupNum + '\'' +
                '}';
    }
}
