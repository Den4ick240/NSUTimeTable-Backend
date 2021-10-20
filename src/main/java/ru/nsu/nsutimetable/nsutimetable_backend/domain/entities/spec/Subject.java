
package ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.spec;

import java.util.List;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Subject {

    private String year;
    private String speciality;
    private String fullName;
    private String cathedra;
    private List<Student> students = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Subject() {
    }

    /**
     * 
     * @param speciality
     * @param year
     * @param fullName
     * @param students
     * @param cathedra
     */
    public Subject(String year, String speciality, String fullName, String cathedra, List<Student> students) {
        super();
        this.year = year;
        this.speciality = speciality;
        this.fullName = fullName;
        this.cathedra = cathedra;
        this.students = students;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCathedra() {
        return cathedra;
    }

    public void setCathedra(String cathedra) {
        this.cathedra = cathedra;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Subject.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("year");
        sb.append('=');
        sb.append(((this.year == null)?"<null>":this.year));
        sb.append(',');
        sb.append("speciality");
        sb.append('=');
        sb.append(((this.speciality == null)?"<null>":this.speciality));
        sb.append(',');
        sb.append("fullName");
        sb.append('=');
        sb.append(((this.fullName == null)?"<null>":this.fullName));
        sb.append(',');
        sb.append("cathedra");
        sb.append('=');
        sb.append(((this.cathedra == null)?"<null>":this.cathedra));
        sb.append(',');
        sb.append("students");
        sb.append('=');
        sb.append(((this.students == null)?"<null>":this.students));
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
        result = ((result* 31)+((this.speciality == null)? 0 :this.speciality.hashCode()));
        result = ((result* 31)+((this.fullName == null)? 0 :this.fullName.hashCode()));
        result = ((result* 31)+((this.students == null)? 0 :this.students.hashCode()));
        result = ((result* 31)+((this.cathedra == null)? 0 :this.cathedra.hashCode()));
        result = ((result* 31)+((this.year == null)? 0 :this.year.hashCode()));
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
        return ((((((this.speciality == rhs.speciality)||((this.speciality!= null)&&this.speciality.equals(rhs.speciality)))&&((this.fullName == rhs.fullName)||((this.fullName!= null)&&this.fullName.equals(rhs.fullName))))&&((this.students == rhs.students)||((this.students!= null)&&this.students.equals(rhs.students))))&&((this.cathedra == rhs.cathedra)||((this.cathedra!= null)&&this.cathedra.equals(rhs.cathedra))))&&((this.year == rhs.year)||((this.year!= null)&&this.year.equals(rhs.year))));
    }

}
