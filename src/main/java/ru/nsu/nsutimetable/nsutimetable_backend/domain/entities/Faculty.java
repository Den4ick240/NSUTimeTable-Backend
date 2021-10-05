
package ru.nsu.nsutimetable.nsutimetable_backend.domain.entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Faculty {

    private String name;
    private String fullName;
    private List<Course> courses = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Faculty() {
    }

    /**
     * 
     * @param courses
     * @param name
     * @param fullName
     */
    public Faculty(String name, String fullName, List<Course> courses) {
        super();
        this.name = name;
        this.fullName = fullName;
        this.courses = courses;
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

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
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
        sb.append(Faculty.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("fullName");
        sb.append('=');
        sb.append(((this.fullName == null)?"<null>":this.fullName));
        sb.append(',');
        sb.append("courses");
        sb.append('=');
        sb.append(((this.courses == null)?"<null>":this.courses));
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
        result = ((result* 31)+((this.fullName == null)? 0 :this.fullName.hashCode()));
        result = ((result* 31)+((this.courses == null)? 0 :this.courses.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
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
        return (((((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name)))&&((this.fullName == rhs.fullName)||((this.fullName!= null)&&this.fullName.equals(rhs.fullName))))&&((this.courses == rhs.courses)||((this.courses!= null)&&this.courses.equals(rhs.courses))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
