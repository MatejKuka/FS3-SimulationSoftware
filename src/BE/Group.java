package BE;

import java.util.ArrayList;

public class Group {
    private String groupName;

    private ArrayList studentList;

    public Group(String groupName) {
        this.groupName = groupName;
        this.studentList = new ArrayList();
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public ArrayList getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Group" + ": groupName" + groupName + ", students: " + studentList;
    }
}
