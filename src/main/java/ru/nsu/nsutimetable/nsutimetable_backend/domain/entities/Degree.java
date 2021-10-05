
package ru.nsu.nsutimetable.nsutimetable_backend.domain.entities;

import java.util.List;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Degree {

    private String name;
    private List<Course> courses = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Degree() {
    }

    /**
     * 
     * @param courses
     * @param name
     */
    public Degree(String name, List<Course> courses) {
        super();
        this.name = name;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Degree.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("courses");
        sb.append('=');
        sb.append(((this.courses == null)?"<null>":this.courses));
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
        result = ((result* 31)+((this.courses == null)? 0 :this.courses.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Degree) == false) {
            return false;
        }
        Degree rhs = ((Degree) other);
        return (((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name)))&&((this.courses == rhs.courses)||((this.courses!= null)&&this.courses.equals(rhs.courses))));
    }

}
