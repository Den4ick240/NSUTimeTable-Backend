
package ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.spec;

import java.util.List;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Faculty {

    private String name;
    private List<Degree> degrees = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Faculty() {
    }

    /**
     * 
     * @param name
     * @param degrees
     */
    public Faculty(String name, List<Degree> degrees) {
        super();
        this.name = name;
        this.degrees = degrees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Degree> getDegrees() {
        return degrees;
    }

    public void setDegrees(List<Degree> degrees) {
        this.degrees = degrees;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Faculty.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("degrees");
        sb.append('=');
        sb.append(((this.degrees == null)?"<null>":this.degrees));
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
        result = ((result* 31)+((this.degrees == null)? 0 :this.degrees.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Faculty) == false) {
            return false;
        }
        Faculty rhs = ((Faculty) other);
        return (((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name)))&&((this.degrees == rhs.degrees)||((this.degrees!= null)&&this.degrees.equals(rhs.degrees))));
    }

}
