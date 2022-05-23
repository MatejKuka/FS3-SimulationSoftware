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

//       UserDAO userDAO = new UserDAO();

//        User user = new Student(7, "Lala", "Lochnes","UserName", "Pass", 3);

//        userDAO.createStudent("Samassn", "Lochnes", "UserName", "Pass", 1);
//        userDAO.updateUser(user);
//        userDAO.getAllUsers();
//        userDAO.getAllAdmins();
//        userDAO.getAllStudents();
//        userDAO.getAllTeachers();
//        userDAO.deleteUser(user);

        //After refactor////////////
//        userDAO.getAllAdmins(1);

//        TeacherStudentDAO teacherStudentDAO = new TeacherStudentDAO();

//        User student = new Student(2, "Lala", "Lochnes","UserName", "Pass", 3);
//        User teacher = new Teacher(11, "Saman", "Lochnes","UserName", "Pass", 2);

//        teacherStudentDAO.getTeacherStudents(6);
//        teacherStudentDAO.addStudentToTeacher(student, teacher);
//        teacherStudentDAO.removeStudentFromTeacher(student, teacher);

//        UsersSchoolDAO usersSchoolDAO = new UsersSchoolDAO();

//        usersSchoolDAO.addUserToSchool(student, school);
//        usersSchoolDAO.removeUserFromSchool(student, school);

//        GeneralInformationDAO generalInformationDAO = new GeneralInformationDAO();

//        GeneralInfo generalInfo = new GeneralInfo(1,"Metju Kuka", "Mastery","Mastery","Mastery","Mastery","Mastery","Mastery",
//                                "Mastery","Mastery","Mastery", "Mastery");

//        Citizen citizen = new Citizen(4, "Loptos", "Heteracik", 2, 1);

//        generalInformationDAO.createGeneralInfo("Saman", "Mastery","Mastery","Mastery","Mastery","Mastery","Mastery",
//                "Mastery","Mastery","Mastery", "Mastery");

//        generalInformationDAO.updateGeneralInfo(generalInfo);
//        generalInformationDAO.getGeneralInfo(generalInfo.getId());
//        generalInformationDAO.getGeneralInfo(citizen.getGeneralInfo());

        CitizenDAO citizenDAO  = new CitizenDAO();

//        Citizen citizen = new Citizen(7, "Loptos", "Heteracik", 2, 2);

//        citizenDAO.createCitizen("Saman", "Lepros", 1, 2);
//        citizenDAO.updateCitizen(citizen);
//        citizenDAO.getAllCitizenFromOneSchool(1);
//        citizenDAO.deleteCitizen(citizen, citizen.getGeneralInfo());
        citizenDAO.getCitizenById(3);

//        HealthConditionsDAO healthConditionsDAO = new HealthConditionsDAO();
//
//        HealthConditions healthConditions = new HealthConditions(1,"Else", "else", "something", "something",
//                                                "something", "something", 11, 2);

//        healthConditionsDAO.createHealthCondition("something", "something", "something", "something",
//                                                "something", "something", 10, 2);
//        healthConditionsDAO.updateHealthConditions(healthConditions);
//        healthConditionsDAO.getHealthCondition(2);

//        CitizensAssessmentDAO citizensAssessmentDAO = new CitizensAssessmentDAO();

//        CitizensAssessment citizensAssessment = new CitizensAssessment(1, "best", "best", "best", "best", "best", 3, 2);

//        citizensAssessmentDAO.createCitizensAssessment("best", "best", "best", "best", "best", 17, 2);
//        citizensAssessmentDAO.updateCitizenAssessment(citizensAssessment);
//        citizensAssessmentDAO.getCitizenAssessment(2);

//        FunctionalityStateDAO functionalityStateDAO = new FunctionalityStateDAO();
//
//        FunctionalityState functionalityState = new FunctionalityState(1, 2, 3, "saman", "243", 2, 2);
//        functionalityStateDAO.createFunctionalityState(2, 3, "saman", "243", 2, 2);
//        functionalityStateDAO.updateFunctionalityState(functionalityState);
//        functionalityStateDAO.getCitizenFunctionalityState(2);

//        StudentCitizenDAO studentCitizenDAO = new StudentCitizenDAO();
//
//        Student student = new Student(3, "Lala", "Lochnes","UserName", "Pass", 3);
//        Citizen citizen = new Citizen(4, "Loptos", "Heteracik", 2, 1);

//        studentCitizenDAO.getStudentCitizens(3);
//        studentCitizenDAO.removeCitizenFromStudent(student, citizen);
//        studentCitizenDAO.addCitizenToStudent(student, citizen);
    }
}
