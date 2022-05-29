package BLL.utils;

import BE.Admin;
import BE.Student;
import BE.Teacher;
import BE.User;

public class UserFactory {
    public enum UserType{
        ADMIN(1),
        TEACHER(2),
        STUDENT(3);


        private final int idInDatabase;

        UserType(int idInDatabase) {
            this.idInDatabase = idInDatabase;
        }

        public int getIdInDatabase() {
            return idInDatabase;
        }
    }

    public User createUser(int userID, String firstName, String lastName, String loginName, String password, UserType userType){
        switch (userType){
            case ADMIN -> {
                return new Admin(userID, firstName, lastName, loginName, password, 1);
            }
            case TEACHER -> {
                return new Teacher(userID, firstName, lastName, loginName, password, 2);
            }
            case STUDENT -> {
                return new Student(userID, firstName, lastName, loginName, password, 3);
            }
            default -> System.out.println("nothing");
        }
        return null;
    }
}
