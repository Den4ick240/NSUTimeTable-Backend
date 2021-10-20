
package ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.spec;

import java.util.List;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class SpecCourses {

    private List<Faculty> faculties = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SpecCourses() {
    }

    /**
     * 
     * @param faculties
     */
    public SpecCourses(List<Faculty> faculties) {
        super();
        this.faculties = faculties;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SpecCourses.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("faculties");
        sb.append('=');
        sb.append(((this.faculties == null)?"<null>":this.faculties));
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
        result = ((result* 31)+((this.faculties == null)? 0 :this.faculties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SpecCourses) == false) {
            return false;
        }
        SpecCourses rhs = ((SpecCourses) other);
        return ((this.faculties == rhs.faculties)||((this.faculties!= null)&&this.faculties.equals(rhs.faculties)));
    }

}
