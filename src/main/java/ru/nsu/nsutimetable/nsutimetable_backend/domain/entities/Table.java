
package ru.nsu.nsutimetable.nsutimetable_backend.domain.entities;

import java.util.List;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Table {

    private Integer dayNum;
    private List<Subject> subjects = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Table() {
    }

    /**
     * 
     * @param subjects
     * @param dayNum
     */
    public Table(Integer dayNum, List<Subject> subjects) {
        super();
        this.dayNum = dayNum;
        this.subjects = subjects;
    }

    public Integer getDayNum() {
        return dayNum;
    }

    public void setDayNum(Integer dayNum) {
        this.dayNum = dayNum;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Table.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("dayNum");
        sb.append('=');
        sb.append(((this.dayNum == null)?"<null>":this.dayNum));
        sb.append(',');
        sb.append("subjects");
        sb.append('=');
        sb.append(((this.subjects == null)?"<null>":this.subjects));
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
        result = ((result* 31)+((this.dayNum == null)? 0 :this.dayNum.hashCode()));
        result = ((result* 31)+((this.subjects == null)? 0 :this.subjects.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Table) == false) {
            return false;
        }
        Table rhs = ((Table) other);
        return (((this.dayNum == rhs.dayNum)||((this.dayNum!= null)&&this.dayNum.equals(rhs.dayNum)))&&((this.subjects == rhs.subjects)||((this.subjects!= null)&&this.subjects.equals(rhs.subjects))));
    }

}
