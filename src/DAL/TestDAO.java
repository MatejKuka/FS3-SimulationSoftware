package DAL;

import BE.School;

import java.io.IOException;

public class TestDAO {
    public static void main(String[] args) throws Exception {

        SchoolDAO schoolDAO = new SchoolDAO();

        School school = new School(2,"SOSU", "Copenhagen");

//        schoolDAO.createSchool(school.getName(), school.getCity());
//        schoolDAO.updateSchool(school);
//        schoolDAO.deleteSchool(school);
//        schoolDAO.getAllCustomers();
    }
}
