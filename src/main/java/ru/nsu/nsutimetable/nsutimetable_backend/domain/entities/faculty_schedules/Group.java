
package ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.faculty_schedules;

import java.util.List;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Group {

    private String groupNum;
    private List<Table> table = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Group() {
    }

    /**
     * 
     * @param groupNum
     * @param table
     */
    public Group(String groupNum, List<Table> table) {
        super();
        this.groupNum = groupNum;
        this.table = table;
    }

    public String getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(String groupNum) {
        this.groupNum = groupNum;
    }

    public List<Table> getTable() {
        return table;
    }

    public void setTable(List<Table> table) {
        this.table = table;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Group.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("groupNum");
        sb.append('=');
        sb.append(((this.groupNum == null)?"<null>":this.groupNum));
        sb.append(',');
        sb.append("table");
        sb.append('=');
        sb.append(((this.table == null)?"<null>":this.table));
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
        result = ((result* 31)+((this.groupNum == null)? 0 :this.groupNum.hashCode()));
        result = ((result* 31)+((this.table == null)? 0 :this.table.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Group) == false) {
            return false;
        }
        Group rhs = ((Group) other);
        return (((this.groupNum == rhs.groupNum)||((this.groupNum!= null)&&this.groupNum.equals(rhs.groupNum)))&&((this.table == rhs.table)||((this.table!= null)&&this.table.equals(rhs.table))));
    }

}
