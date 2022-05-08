package DAL;

import BE.*;

public class TestDAO {
    public static void main(String[] args) throws Exception {

        //SchoolDAO schoolDAO = new SchoolDAO();

        //School school = new School(2,"Test", "Zvolen");

        //schoolDAO.createSchool(school.getName(), school.getCity());
//        schoolDAO.updateSchool(school);
//        schoolDAO.deleteSchool(school);
//        schoolDAO.getAllCustomers();

//        UserDAO userDAO = new UserDAO();

//        User user = new Student(12, "Lala", "Lochnes","UserName", "Pass", 3);

//        userDAO.createStudent("Saman", "Lochnes", "UserName", "Pass");
//        userDAO.updateUser(user);
//        userDAO.getAllUsers();
//        userDAO.getAllAdmins();
//        userDAO.getAllStudents();
//        userDAO.getAllTeachers();
//        userDAO.deleteUser(user);

//        TeacherStudentDAO teacherStudentDAO = new TeacherStudentDAO();

//        User student = new Student(2, "Lala", "Lochnes","UserName", "Pass", 3);
//        User teacher = new Teacher(11, "Saman", "Lochnes","UserName", "Pass", 2);

//        teacherStudentDAO.addStudentToTeacher(student, teacher);
//        teacherStudentDAO.removeStudentFromTeacher(student, teacher);

//        UsersSchoolDAO usersSchoolDAO = new UsersSchoolDAO();

//        usersSchoolDAO.addUserToSchool(student, school);
//        usersSchoolDAO.removeUserFromSchool(student, school);

//        GeneralInformationDAO generalInformationDAO = new GeneralInformationDAO();

//        GeneralInfo generalInfo = new GeneralInfo(1,"Metju Kuka", "Mastery","Mastery","Mastery","Mastery","Mastery","Mastery",
//                                "Mastery","Mastery","Mastery", "Mastery");

//        Citizen citizen = new Citizen(4, "Loptos", "Heteracik", 2, 1);

//        generalInformationDAO.createGeneralInfo("Mastery", "Mastery","Mastery","Mastery","Mastery","Mastery","Mastery",
//                "Mastery","Mastery","Mastery", "Mastery");

//        generalInformationDAO.updateGeneralInfo(generalInfo);
//        generalInformationDAO.getGeneralInfo(generalInfo.getId());
//        generalInformationDAO.getGeneralInfo(citizen.getGeneralInfo());

//        CitizenDAO citizenDAO  = new CitizenDAO();

//        Citizen citizen = new Citizen(6, "Loptos", "Heteracik", 2, 1);

//        citizenDAO.createCitizen("Saman", "Lepros", 1, 1);
//        citizenDAO.updateCitizen(citizen);
//        citizenDAO.getAllCitizenFromOneSchool(1);
//        citizenDAO.deleteCitizen(citizen);

        HealthConditionsDAO healthConditionsDAO = new HealthConditionsDAO();

        healthConditionsDAO.createHealthCondition();
        healthConditionsDAO.updateHealthConditions();
        healthConditionsDAO.getHealthCondition();
//        CitizensAssessmentDAO citizensAssessmentDAO = new CitizensAssessmentDAO();
//        FunctionalityStateDAO functionalityStateDAO = new FunctionalityStateDAO();
    }
}
