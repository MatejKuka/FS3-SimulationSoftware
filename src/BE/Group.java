package BE;

import java.util.ArrayList;

public class Group {
    private String groupName;

    private ArrayList<User> studentList;

    public Group(String groupName, ArrayList<User> studentList) {
        this.groupName = groupName;
        this.studentList = studentList;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public ArrayList<User> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<User> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Group" + ": groupName" + groupName + ", students: " + studentList;
    }
}
