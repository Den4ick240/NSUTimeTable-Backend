
package ru.nsu.nsutimetable.nsutimetable_backend.domain.entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Table {

    private Integer dayNum;
    private String name;
    private List<Subject> subjects = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Table() {
    }

    /**
     * 
     * @param subjects
     * @param name
     * @param dayNum
     */
    public Table(Integer dayNum, String name, List<Subject> subjects) {
        super();
        this.dayNum = dayNum;
        this.name = name;
        this.subjects = subjects;
    }

    public Integer getDayNum() {
        return dayNum;
    }

    public void setDayNum(Integer dayNum) {
        this.dayNum = dayNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Table.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("dayNum");
        sb.append('=');
        sb.append(((this.dayNum == null)?"<null>":this.dayNum));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("subjects");
        sb.append('=');
        sb.append(((this.subjects == null)?"<null>":this.subjects));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
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
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.dayNum == null)? 0 :this.dayNum.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
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
        return (((((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name)))&&((this.dayNum == rhs.dayNum)||((this.dayNum!= null)&&this.dayNum.equals(rhs.dayNum))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.subjects == rhs.subjects)||((this.subjects!= null)&&this.subjects.equals(rhs.subjects))));
    }

}
