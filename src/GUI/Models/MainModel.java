package GUI.Models;

import BE.*;
import BLL.exeptions.UserException;
import BLL.facadeBLL.FacadeBLL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.util.List;

public class MainModel {

    private static int idRole;
    private static int currentSchoolId;
    public static User currrentUser;
    public static Citizen clickedCitizen;
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
    FacadeBLL manager;
    ObservableList<User> userObservableList;


    public MainModel() throws IOException {
        manager = new FacadeBLL();
        students = FXCollections.observableArrayList();
        admins = FXCollections.observableArrayList();
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

    public ObservableList<User> getAllUsers() throws UserException {
        users.setAll(manager.getAllUsers());
        return users;
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


    public ObservableList<User> getUsersByRole(int roleID) throws UserException {

        if (roleID == 1) userObservableList.setAll(getAllAdminsFromOneSchool());
        else if (roleID == 2) userObservableList.setAll(getAllTeacher());
        else if (roleID == 3) userObservableList.setAll(getAllStudents());

        return userObservableList;
    }

    public void deleteUser(User user) throws UserException {
        removeUserFromSchool(user, getCurrentSchool());
        manager.deleteUser(user);
        userObservableList.remove(user);
        System.out.println("user is deleted: " + user);
    }

    public void updateUser(User user) throws UserException {
        manager.updateUser(user);
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

    public User setCurrentUser(User user) {
        currrentUser = user;
        System.out.println("Current user: " + currrentUser);
        return currrentUser;
    }

    public User getCurrentUser() {
        return currrentUser;
    }

    public int setCurrentSchoolId(User user) throws UserException {
        currentSchoolId = returnUsersSchoolID(user);
        System.out.println("Id of the current school:" + currentSchoolId);
        return currentSchoolId;
    }

    public int getCurrentSchoolId() {
        return currentSchoolId;
    }

    public int returnUsersSchoolID(User user) throws UserException {
        return manager.returnUsersSchoolID(user);
    } // TODO Matej - all these methods for setting something(school, currentUser,...) can be easily put in facade or in one method

    public GeneralInfo getGeneralInfo(int idGeneralInfo) throws UserException {
        return manager.getGeneralInfo(idGeneralInfo);
    }

    public ObservableList<FunctionalityState> getCitizenFunctionalityState(int idCitizen) throws UserException {
        functionalityStates.setAll(manager.getCitizenFunctionalityState(idCitizen));
        return functionalityStates;
    }


    public User createStudent(String firstName, String lastName, String loginName, String password) throws UserException {
        User studentNew = manager.createStudent(firstName, lastName, loginName, password);
        System.out.println(getCurrentSchool());
        addUserToSchool(studentNew, getSchoolById(getCurrentSchoolId())); // TODO Matej - needs to be changed to Id of school when Oliver change the methods in DAO

        students.add(studentNew);
        System.out.println("new student created: " + studentNew);
        return studentNew;
    }

    public User createAdmin(String firstName, String lastName, String loginName, String password) throws UserException {
        User adminNew = manager.createAdmin(firstName, lastName, loginName, password);
        admins.add(adminNew);
        return manager.createAdmin(firstName, lastName, loginName, password);
    } // This Method creates an admin without any assigned school

    public User createAdminInSchool(String firstName, String lastName, String loginName, String password) throws UserException {
        User userAdmin = manager.createAdmin(firstName, lastName, loginName, password);
        addUserToSchool(userAdmin, getSchoolById(getCurrentSchoolId()));
        adminsBySchool.add(userAdmin);
        return userAdmin;
    }

    public User createTeacher(String firstName, String lastName, String loginName, String password) throws UserException {
        User teacherNew = manager.createTeacher(firstName, lastName, loginName, password);
        addUserToSchool(teacherNew, getSchoolById(getCurrentSchoolId())); // TODO Matej - needs to be changed to Id of school when Oliver change the methods in DAO
        teachers.add(teacherNew);
        System.out.println("new teacher created: " + teacherNew);
        return teacherNew;

    }

    public List<FunctionalityState> getFunctionalityStateById(int id) throws UserException {
        return manager.getCitizenFunctionalityState(id);
    }

    public Citizen setCurrentCitizen(Citizen citizen) {
        clickedCitizen = citizen;
        System.out.println("Current citizen: " + clickedCitizen);
        return clickedCitizen;
    }

    public Citizen getCurrentCitizen() {
        return clickedCitizen;
    } // TODO Matej - This needs to be fixed because the name is confussing

    public School setCurrentSchool(School school) {
        clickedSchool = school;
        return clickedSchool;
    } // TODO Matej - This needs to be fixed because the name is confussing

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
        System.out.println("Citizen added to observable: " + citizenBla);
        return citizenBla;
    }
    public List<GeneralInfo> getAllGeneralInfo() throws UserException {
        return manager.getAllGeneralInfo();
    }
    public ObservableList<School> getAllSchools() throws UserException {
        schools.setAll(manager.getAllSchools());
        return schools;
    }

    public School createSchool(String name, String city) throws UserException {
        return manager.createSchool(name, city);
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

    public void addUserToSchool(User user, School school) throws UserException {
        manager.addUserToSchool(user, getSchoolById(getCurrentSchoolId()));
    } // TODO Matej - needs to be changed to Id of school when Oliver change the methods in DAO

    public void removeUserFromSchool(User user, School school) throws UserException {
        manager.removeUserFromSchool(user, getSchoolById(getCurrentSchoolId()));
    } // TODO Matej - needs to be changed to Id of school when Oliver change the methods in DAO

    public School getSchoolById(int schoolId) throws UserException {
        return manager.getSchoolById(schoolId);
    }
    public void updateGeneralInfo(GeneralInfo generalInfo) throws UserException {
        manager.updateGeneralInfo(generalInfo);
    }

    public void addCitizenToStudent(Student student, Citizen citizen) throws UserException {
        manager.addCitizenToStudent(student, citizen);
    }

    public void removeCitizenFromStudent(User student, Citizen citizen) throws UserException {
        manager.removeCitizenFromStudent(student, citizen);
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

    public HealthConditions createHealthCondition(String SaveAs, String ProfessNote, String CurrAssess, String ExpectedLvl, String FollUpDate, String ObservNote, int TypeOfCase, int Citizen) throws UserException {
        return manager.createHealthCondition(SaveAs, ProfessNote, CurrAssess, ExpectedLvl, FollUpDate, ObservNote, TypeOfCase, Citizen);
    }

    public void setChosenCitizenFillUp(Citizen citizenCh) {
        chosenCitizenToFillUp = citizenCh;
        System.out.println("Current Citizen to fill up: " + chosenCitizenToFillUp);
    }

    public Citizen getChosenCitizenFillUp() {
        return chosenCitizenToFillUp;
    }

    public FunctionalityState createFunctionalityState(int currLvl, int expectedLvl, String professNote, String saveAs, int functionalityType, int citizen) throws UserException {
        return manager.createFunctionalityState(currLvl, expectedLvl, professNote, saveAs, functionalityType, citizen);
    }

    public void updateFunctionalityState(FunctionalityState functionalityState) throws Exception {
        manager.updateFunctionalityState(functionalityState);
    }

    public List<CitizensAssessment> getCitizenAssessmentsById(int id) throws Exception {
        return manager.getCitizenAssessmentById(id);
    }

    public CitizensAssessment createCitizensAssessments(String performance, String importance, String citizWishes, String follUpDate, String observNote, int functionalityType, int citizen) throws Exception {
        return manager.createCitizensAssessment(performance, importance, citizWishes, follUpDate, observNote, functionalityType, citizen);
    }
}
