package ru.nsu.nsutimetable.nsutimetable_backend.domain.entities;

import java.util.Objects;

public class GroupInfo {
    private String groupNum = null;
    private Integer courseNum = null;
    private String degree = null;
    private String faculty = null;

    public GroupInfo() {
    }

    public GroupInfo(String groupNum, Integer courseNum, String degree, String faculty) {
        this.groupNum = groupNum;
        this.courseNum = courseNum;
        this.degree = degree;
        this.faculty = faculty;
    }

    public String getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(String groupNum) {
        this.groupNum = groupNum;
    }

    public Integer getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(Integer courseNum) {
        this.courseNum = courseNum;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "GroupInfo{" +
                "groupNum=" + groupNum +
                ", courseNum=" + courseNum +
                ", degree='" + degree + '\'' +
                ", faculty='" + faculty + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupInfo groupInfo = (GroupInfo) o;
        return Objects.equals(groupNum, groupInfo.groupNum) && Objects.equals(courseNum, groupInfo.courseNum) && Objects.equals(degree, groupInfo.degree) && Objects.equals(faculty, groupInfo.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupNum, courseNum, degree, faculty);
    }
}
