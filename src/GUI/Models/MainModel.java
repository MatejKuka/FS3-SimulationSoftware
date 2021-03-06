package GUI.Models;

import BE.*;
import BLL.exeptions.UserException;
import BLL.facadeBLL.FacadeBLL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.util.List;

public class MainModel {

    //when user log in static instant variables are set based on DB info about user
    private static int idRole;
    private static int currentSchoolId;
    public static User currentUser;
    public static Citizen chosenCitizenToFillUp;
    public static School clickedSchool;
    private static String nameRole;

    ObservableList<User> students;
    ObservableList<User> teachers;
    ObservableList<User> admins;
    ObservableList<User> adminsBySchool;
    ObservableList<User> users;
    ObservableList<School> schools;
    ObservableList<FunctionalityState> functionalityStates;
    ObservableList<Citizen> citizensBySchool;
    ObservableList<User> userObservableList;

    FacadeBLL manager;

    public MainModel() throws IOException {
        //singleton
        manager = FacadeBLL.getInstance();

        students = FXCollections.observableArrayList();
        admins = FXCollections.observableArrayList();
        adminsBySchool = FXCollections.observableArrayList();
        schools = FXCollections.observableArrayList();
        teachers = FXCollections.observableArrayList();
        users = FXCollections.observableArrayList();
        citizensBySchool = FXCollections.observableArrayList();
        functionalityStates = FXCollections.observableArrayList();
        userObservableList = FXCollections.observableArrayList();
    }

    public User compareLogins(String username, String password) throws UserException {
        return manager.compareLogins(username, password);
    }

    public ObservableList<User> getAllStudents() throws UserException {
        students.setAll(manager.getAllStudentsFromOneSchool(getCurrentSchoolId()));
        return students;
    }

    public ObservableList<User> getAllAdmins() throws UserException {
        admins.setAll(manager.getAllAdmins());
        return admins;
    }

    public ObservableList<User> getAllAdminsFromOneSchool() throws UserException {
        adminsBySchool.setAll(manager.getAllAdminsFromOneSchool(getCurrentSchoolId()));
        return adminsBySchool;
    }

    public ObservableList<User> getAllTeacher() throws UserException {
        teachers.setAll(manager.getAllTeacherFromOneSchool(getCurrentSchoolId()));
        return teachers;
    }

    // This method returns an observable list of Users depending of the roleID in the parameter
    public ObservableList<User> getUsersByRole(int roleID) throws UserException {
        if (roleID == 1) userObservableList.setAll(getAllAdminsFromOneSchool());
        else if (roleID == 2) userObservableList.setAll(getAllTeacher());
        else if (roleID == 3) userObservableList.setAll(getAllStudents());
        return userObservableList;
    }

    public void deleteUser(User user) throws UserException {
        manager.deleteUser(user);
        userObservableList.remove(user);
    }

    public void updateUser(int id, String firstName, String lastName, String loginName, String password) throws UserException {
        manager.updateUser(id, firstName, lastName, loginName, password);
    }

    public void changeRoleId(int number) {
        idRole = number;
    }

    public int getRoleId() {
        return idRole;
    }


    public void changeRoleName(int roleID) {
        if (roleID == 1) nameRole = "Admins";
        else if (roleID == 2) nameRole = "Teachers";
        else if (roleID == 3) nameRole = "Students";
    }

    public String getRoleName() {
        return nameRole;
    }

    public ObservableList<Citizen> getAllCitizenFromOneSchool(int schoolId) throws UserException {
        citizensBySchool.setAll(manager.getAllCitizenFromOneSchool(schoolId));
        return citizensBySchool;
    }

    public void setCurrentUser(User user) {
        currentUser = user;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentSchoolId(User user) throws UserException {
        currentSchoolId = returnUsersSchoolID(user);
    }

    public int getCurrentSchoolId() {
        return currentSchoolId;
    }

    public int returnUsersSchoolID(User user) throws UserException {
        return manager.returnUsersSchoolID(user);
    }

    public void createStudent(String firstName, String lastName, String loginName, String password) throws UserException {
        User studentNew = manager.createStudent(firstName, lastName, loginName, password);
        addUserToSchool(studentNew);
        students.add(studentNew);
    }

    public void createAdmin(String firstName, String lastName, String loginName, String password) throws UserException {
        User adminNew = manager.createAdmin(firstName, lastName, loginName, password);
        admins.add(adminNew);
        manager.createAdmin(firstName, lastName, loginName, password);
    }

    public void createTeacher(String firstName, String lastName, String loginName, String password) throws UserException {
        User teacherNew = manager.createTeacher(firstName, lastName, loginName, password);
        addUserToSchool(teacherNew);
        teachers.add(teacherNew);

    }

    public List<FunctionalityState> getFunctionalityStateById(int id) throws UserException {
        return manager.getCitizenFunctionalityState(id);
    }

    public void setCurrentSchool(School school) {
        clickedSchool = school;
    }

    public School getCurrentSchool() {
        return clickedSchool;
    }

    public void updateCitizen(Citizen citizen) throws UserException {
        manager.updateCitizen(citizen);
    }

    public void deleteCitizen(Citizen citizen) throws UserException {
        citizensBySchool.remove(citizen);
        manager.deleteCitizen(citizen);
    }

    public GeneralInfo createGeneralInfo(String mastery, String motivation, String resources, String roller, String habits, String educationJob, String lifeStory, String healthInfo, String assistiveDevices, String interiorOfDwelling, String network, int citizenId) throws UserException {
        return manager.createGeneralInfo(mastery, motivation, resources, roller, habits, educationJob, lifeStory, healthInfo, assistiveDevices, interiorOfDwelling, network, citizenId);
    }

    public Citizen createCitizen(String fName, String lName, int school) throws UserException {
        Citizen citizenBla = manager.createCitizen(fName, lName, school);
        citizensBySchool.add(citizenBla);
        return citizenBla;
    }

    public List<GeneralInfo> getAllGeneralInfo() throws UserException {
        return manager.getAllGeneralInfo();
    }

    public ObservableList<School> getAllSchools() throws UserException {
        schools.setAll(manager.getAllSchools());
        return schools;
    }

    public void createSchool(String name, String city) throws UserException {
        manager.createSchool(name, city);
    }

    public void deleteSchool(School school) throws UserException {
        manager.deleteSchool(school);
    }

    public void updateSchool(School school) throws UserException {
        manager.updateSchool(school);
    }

    public Citizen getCitizenById(int id) throws UserException {
        return manager.getCitizenById(id);
    }

    public void addUserToSchool(User user) throws UserException {
        manager.addUserToSchool(user, getSchoolById(getCurrentSchoolId()));
    }

    public School getSchoolById(int schoolId) throws UserException {
        return manager.getSchoolById(schoolId);
    }

    public void updateGeneralInfo(GeneralInfo generalInfo) throws UserException {
        manager.updateGeneralInfo(generalInfo);
    }

    /////////////////////
    public void addCitizenToStudent(Student student, Citizen citizen) throws UserException {
        manager.addCitizenToStudent(student, citizen);
    }

    public List<Citizen> getStudentCitizens(int studentId) throws UserException {
        return manager.getStudentCitizens(studentId);
    }

    public List<HealthConditions> getHealthCondition(int idCitizen) throws UserException {
        return manager.getHealthCondition(idCitizen);
    }

    public void updateHealthConditions(HealthConditions healthConditions) throws UserException {
        manager.updateHealthConditions(healthConditions);
    }

    public void createHealthCondition(String SaveAs, String ProfessNote, String CurrAssess, String ExpectedLvl, String FollUpDate, String ObservNote, int TypeOfCase, int Citizen) throws UserException {
        manager.createHealthCondition(SaveAs, ProfessNote, CurrAssess, ExpectedLvl, FollUpDate, ObservNote, TypeOfCase, Citizen);
    }

    public void setChosenCitizenFillUp(Citizen citizenCh) {
        chosenCitizenToFillUp = citizenCh;
    }

    public Citizen getChosenCitizenFillUp() {
        return chosenCitizenToFillUp;
    }

    public FunctionalityState createFunctionalityState(int currLvl, int expectedLvl, String professNote, String saveAs, int functionalityType, int citizen) throws UserException {
        return manager.createFunctionalityState(currLvl, expectedLvl, professNote, saveAs, functionalityType, citizen);
    }

    public void updateFunctionalityState(FunctionalityState functionalityState) throws UserException {
        manager.updateFunctionalityState(functionalityState);
    }

    public void updateCitizensAssessment(CitizensAssessment citizensAssessment) throws UserException {
        manager.updateCitizensAssessment(citizensAssessment);
    }

    public List<CitizensAssessment> getCitizenAssessmentsById(int id) throws UserException {
        return manager.getCitizenAssessmentById(id);
    }

    public CitizensAssessment createCitizensAssessments(String performance, String importance, String citizWishes, String follUpDate, String observNote, int functionalityType, int citizen) throws UserException {
        return manager.createCitizensAssessment(performance, importance, citizWishes, follUpDate, observNote, functionalityType, citizen);
    }
}
