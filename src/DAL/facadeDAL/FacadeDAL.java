package DAL.facadeDAL;

import BE.*;
import DAL.*;

import java.io.IOException;
import java.util.List;

public class FacadeDAL implements IFacadeDAL{
    private static FacadeDAL instance;

    UserDAO userDAO;
    CitizenDAO citizenDAO;
    UsersSchoolDAO usersSchoolDAO;
    GeneralInformationDAO generalInformationDAO;
    TeacherStudentDAO teacherStudentDAO;
    SchoolDAO schoolDAO;
    HealthConditionsDAO healthConditionsDAO;
    FunctionalityStateDAO functionalityStateDAO;
    CitizensAssessmentDAO citizensAssessmentDAO;
    StudentCitizenDAO studentCitizenDAO;

    public FacadeDAL() throws IOException {
        userDAO = new UserDAO();
        citizenDAO = new CitizenDAO();
        usersSchoolDAO = new UsersSchoolDAO();
        generalInformationDAO = new GeneralInformationDAO();
        teacherStudentDAO = new TeacherStudentDAO();
        schoolDAO = new SchoolDAO();
        healthConditionsDAO = new HealthConditionsDAO();
        functionalityStateDAO = new FunctionalityStateDAO();
        citizensAssessmentDAO = new CitizensAssessmentDAO();
        studentCitizenDAO = new StudentCitizenDAO();
    }


    @Override
    public int returnUsersSchoolID(User user) throws Exception {
        return usersSchoolDAO.returnUsersSchoolID(user);
    }

    @Override
    public void addUserToSchool(User user, School school) throws Exception {
        usersSchoolDAO.addUserToSchool(user, school);
    }

    @Override
    public void removeUserFromSchool(User user, School school) throws Exception {
        usersSchoolDAO.removeUserFromSchool(user, school);
    }

    @Override
    public User compareLogins(String username, String password) throws Exception {
        return userDAO.compareLogins(username, password);
    }

    @Override
    public List<User> getAllUsers() throws Exception {
        return userDAO.getAllUsers();
    }

    @Override
    public List<User> getAllAdmins() throws Exception {
        return userDAO.getAllAdmins();
    }

    @Override
    public List<User> getAllStudents(int schoolId) throws Exception {
        return userDAO.getAllStudents(schoolId);
    }

    @Override
    public List<User> getAllTeacher(int schoolId) throws Exception {
        return userDAO.getAllTeachers(schoolId);
    }

    @Override
    public User createAdmin(String firstName, String lastName, String loginName, String password) throws Exception {
        return userDAO.createAdmin(firstName, lastName, loginName,password);
    }

    @Override
    public User createTeacher(String firstName, String lastName, String loginName, String password) throws Exception {
        return userDAO.createTeacher( firstName,  lastName,  loginName,  password);
    }

    @Override
    public User createStudent(String firstName, String lastName, String loginName, String password) throws Exception {
        return userDAO.createStudent(firstName,  lastName,  loginName,  password);
    }

    @Override
    public void deleteUser(User user) throws Exception {
        userDAO.deleteUser(user);
    }

    @Override
    public void updateUser(User user) throws Exception {
        userDAO.updateUser(user);
    }

    @Override
    public void addStudentToTeacher(Student student, Teacher teacher) throws Exception {
        teacherStudentDAO.addStudentToTeacher(student, teacher);
    }

    @Override
    public void removeStudentFromTeacher(Student student, Teacher teacher) throws Exception {
        teacherStudentDAO.removeStudentFromTeacher(student, teacher);
    }

    public List<User> getTeacherStudents(int teacherId) throws Exception{
        return teacherStudentDAO.getTeacherStudents(teacherId);
    }

    @Override
    public List<School> getAllSchools() throws Exception {
        return schoolDAO.getAllSchools();
    }

    @Override
    public School createSchool(String name, String city) throws Exception {
        return schoolDAO.createSchool(name, city);
    }

    @Override
    public void deleteSchool(School school) throws Exception {
        schoolDAO.deleteSchool(school);
    }

    @Override
    public void updateSchool(School school) throws Exception {
        schoolDAO.updateSchool(school);
    }

    @Override
    public List<HealthConditions> getHealthCondition(int idCitizen) throws Exception {
        return healthConditionsDAO.getHealthCondition(idCitizen);
    }

    @Override
    public void updateHealthConditions(HealthConditions healthConditions) throws Exception {
        healthConditionsDAO.updateHealthConditions(healthConditions);
    }

    @Override
    public HealthConditions createHealthCondition(String SaveAs, String ProfessNote, String CurrAssess, String ExpectedLvl, String FollUpDate, String ObservNote, int TypeOfCase, int Citizen) throws Exception {
        return healthConditionsDAO.createHealthCondition(SaveAs, ProfessNote, CurrAssess, ExpectedLvl, FollUpDate, ObservNote, TypeOfCase, Citizen);
    }

    @Override
    public GeneralInfo getGeneralInfo(int idGeneralInfo) throws Exception {
        return generalInformationDAO.getGeneralInfo(idGeneralInfo);
    }

    @Override
    public GeneralInfo createGeneralInfo(String mastery, String motivation, String resources, String roller, String habits, String educationJob, String lifeStory, String healthInfo, String assistiveDevices, String interiorOfDwelling, String network) throws Exception {
        return generalInformationDAO.createGeneralInfo(mastery, motivation, resources, roller, habits, educationJob, lifeStory, healthInfo, assistiveDevices, interiorOfDwelling, network);
    }

    @Override
    public void updateGeneralInfo(GeneralInfo generalInfo) throws Exception {
        generalInformationDAO.updateGeneralInfo(generalInfo);
    }

    @Override
    public List<FunctionalityState> getCitizenFunctionalityState(int idCitizen) throws Exception {
        return functionalityStateDAO.getCitizenFunctionalityState(idCitizen);
    }

    @Override
    public void updateFunctionalityState(FunctionalityState functionalityState) throws Exception {
        functionalityStateDAO.updateFunctionalityState(functionalityState);
    }

    @Override
    public FunctionalityState createFunctionalityState(int currLvl, int expectedLvl, String professNote, String saveAs, int functionalityType, int citizen) throws Exception {
        return functionalityStateDAO.createFunctionalityState(currLvl, expectedLvl, professNote, saveAs, functionalityType, citizen);
    }

    @Override
    public List<CitizensAssessment> getCitizenAssessment(int idCitizen) throws Exception {
        return citizensAssessmentDAO.getCitizenAssessment(idCitizen);
    }

    @Override
    public void updateCitizenAssessment(CitizensAssessment citizensAssessment) throws Exception {
        citizensAssessmentDAO.updateCitizenAssessment(citizensAssessment);
    }

    @Override
    public CitizensAssessment createCitizensAssessment(String performance, String importance, String citizWishes, String follUpDate, String observNote, int functionalityType, int citizen) throws Exception {
        return citizensAssessmentDAO.createCitizensAssessment(performance, importance, citizWishes, follUpDate, observNote, functionalityType, citizen);
    }

    @Override
    public List<Citizen> getAllCitizenFromOneSchool(int schoolId) throws Exception {
        return citizenDAO.getAllCitizenFromOneSchool(schoolId);
    }

    @Override
    public void updateCitizen(Citizen citizen) throws Exception {
        citizenDAO.updateCitizen(citizen);
    }

    @Override
    public void deleteCitizen(Citizen citizen, int generalInfoIdOfCitizen) throws Exception {
        citizenDAO.deleteCitizen(citizen, generalInfoIdOfCitizen);
    }

    @Override
    public Citizen createCitizen(String fName, String lName, int school, int generalInfo) throws Exception {
        return citizenDAO.createCitizen(fName, lName, school, generalInfo);
    }


    public void addCitizenToStudent(Student student, Citizen citizen) throws Exception{
        studentCitizenDAO.addCitizenToStudent(student, citizen);
    }

    public void removeCitizenFromStudent(User student, Citizen citizen) throws Exception{
        studentCitizenDAO.removeCitizenFromStudent(student, citizen);
    }

    public List<Citizen> getStudentCitizens(int studentId) throws Exception{
        return studentCitizenDAO.getStudentCitizens(studentId);
    }


}
