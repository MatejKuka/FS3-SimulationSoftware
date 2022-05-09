package BE;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

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

    public String getFullName(User user) {
//         clickedRow.getStudentList().forEach(group -> {
//                        AtomicReference<String> name = new AtomicReference<>("");
//                        name.set(group.getFirstName() + " " + group.getLastName());
//                        fullNames.add(String.valueOf(name));
//                    });
        AtomicReference<String> name = new AtomicReference<>("");
        name.set(user.getFirstName() + " " + user.getLastName());
        return String.valueOf(name);
    }

    public void setStudentList(ArrayList<User> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Group" + ": groupName" + groupName + ", students: " + studentList;
    }
}
