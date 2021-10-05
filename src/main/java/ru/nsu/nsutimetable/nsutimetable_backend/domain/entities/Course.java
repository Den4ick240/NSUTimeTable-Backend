
package ru.nsu.nsutimetable.nsutimetable_backend.domain.entities;

import java.util.List;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Course {

    private Integer num;
    private List<Group> groups = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Course() {
    }

    /**
     * 
     * @param num
     * @param groups
     */
    public Course(Integer num, List<Group> groups) {
        super();
        this.num = num;
        this.groups = groups;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Course.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("num");
        sb.append('=');
        sb.append(((this.num == null)?"<null>":this.num));
        sb.append(',');
        sb.append("groups");
        sb.append('=');
        sb.append(((this.groups == null)?"<null>":this.groups));
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
        result = ((result* 31)+((this.groups == null)? 0 :this.groups.hashCode()));
        result = ((result* 31)+((this.num == null)? 0 :this.num.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Course) == false) {
            return false;
        }
        Course rhs = ((Course) other);
        return (((this.groups == rhs.groups)||((this.groups!= null)&&this.groups.equals(rhs.groups)))&&((this.num == rhs.num)||((this.num!= null)&&this.num.equals(rhs.num))));
    }

}
