
package ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.faculty_schedules;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Subject {

    private Integer lessonNum;
    private String name;
    private String fullName;
    private Object odd;
    private String type;
    private String room;
    private String teacher;
    private Boolean optional;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Subject() {
    }

    /**
     * 
     * @param lessonNum
     * @param teacher
     * @param name
     * @param fullName
     * @param optional
     * @param type
     * @param odd
     * @param room
     */
    public Subject(Integer lessonNum, String name, String fullName, Object odd, String type, String room, String teacher, Boolean optional) {
        super();
        this.lessonNum = lessonNum;
        this.name = name;
        this.fullName = fullName;
        this.odd = odd;
        this.type = type;
        this.room = room;
        this.teacher = teacher;
        this.optional = optional;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Object getOdd() {
        return odd;
    }

    public void setOdd(Object odd) {
        this.odd = odd;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public Boolean getOptional() {
        return optional;
    }

    public void setOptional(Boolean optional) {
        this.optional = optional;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Subject.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("lessonNum");
        sb.append('=');
        sb.append(((this.lessonNum == null)?"<null>":this.lessonNum));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("fullName");
        sb.append('=');
        sb.append(((this.fullName == null)?"<null>":this.fullName));
        sb.append(',');
        sb.append("odd");
        sb.append('=');
        sb.append(((this.odd == null)?"<null>":this.odd));
        sb.append(',');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null)?"<null>":this.type));
        sb.append(',');
        sb.append("room");
        sb.append('=');
        sb.append(((this.room == null)?"<null>":this.room));
        sb.append(',');
        sb.append("teacher");
        sb.append('=');
        sb.append(((this.teacher == null)?"<null>":this.teacher));
        sb.append(',');
        sb.append("optional");
        sb.append('=');
        sb.append(((this.optional == null)?"<null>":this.optional));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.lessonNum == null)? 0 :this.lessonNum.hashCode()));
        result = ((result* 31)+((this.teacher == null)? 0 :this.teacher.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.fullName == null)? 0 :this.fullName.hashCode()));
        result = ((result* 31)+((this.optional == null)? 0 :this.optional.hashCode()));
        result = ((result* 31)+((this.type == null)? 0 :this.type.hashCode()));
        result = ((result* 31)+((this.odd == null)? 0 :this.odd.hashCode()));
        result = ((result* 31)+((this.room == null)? 0 :this.room.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Subject) == false) {
            return false;
        }
        Subject rhs = ((Subject) other);
        return (((((((((this.lessonNum == rhs.lessonNum)||((this.lessonNum!= null)&&this.lessonNum.equals(rhs.lessonNum)))&&((this.teacher == rhs.teacher)||((this.teacher!= null)&&this.teacher.equals(rhs.teacher))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.fullName == rhs.fullName)||((this.fullName!= null)&&this.fullName.equals(rhs.fullName))))&&((this.optional == rhs.optional)||((this.optional!= null)&&this.optional.equals(rhs.optional))))&&((this.type == rhs.type)||((this.type!= null)&&this.type.equals(rhs.type))))&&((this.odd == rhs.odd)||((this.odd!= null)&&this.odd.equals(rhs.odd))))&&((this.room == rhs.room)||((this.room!= null)&&this.room.equals(rhs.room))));
    }

}
