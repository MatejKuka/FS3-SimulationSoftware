package GUI.Controllers;

import BE.Group;
import BE.User;
import GUI.Models.MainModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GroupsViewController implements Initializable {
    @FXML
    private TableView<User> studentsTableView;
    @FXML
    private TableView<Group> groupsTableView;
    @FXML
    private TableView<User> groupsDetailTableView;
    @FXML
    private TableColumn<User, String> firstNameCol, lastNameCol;
    @FXML
    private TableColumn<Group, String> groupsName, groupsStudentCount;
    @FXML
    private TableColumn<User, String> detailCol;
    @FXML
    private Button deleteGroupButton;
    @FXML
    private TextArea studentsTextArea, groupTextArea;
    private MainModel mainModel;

    private Boolean isStudentsTableViewClicked = false;
    private Boolean isGroupTableViewClicked = false;

    private User user;
    private Group group;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            mainModel = new MainModel();
            setupStudentsTableView();
            setupGroups();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setupStudentsTableView() throws Exception {
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        studentsTableView.getItems().setAll(mainModel.getUsersByRole(mainModel.getRoleId()));

        studentsTableView.setRowFactory(tv -> {
            TableRow<User> userTableRow = new TableRow<>();
            userTableRow.setOnMouseClicked(event -> {
                if (!userTableRow.isEmpty() && event.getButton() == MouseButton.PRIMARY) {
                    User clickedRow = userTableRow.getItem();
                    user = clickedRow;
                    studentsTextArea.setText("First Name: " + clickedRow.getFirstName() + "\n" + "Second Name: " + clickedRow.getLastName());
                    System.out.println(clickedRow);
                    isStudentsTableViewClicked = true;
                } else {
                    isStudentsTableViewClicked = false;
                }
            });
            return userTableRow;
        });
    }



    private void setupGroups() {
//        int userID, String firstName, String lastName, String loginName, String password, int roleID
        User u1 = new User(1, "Pavol", "Habera", "vlasatykokot", "roko", 2);
        User u2 = new User(2, "Jozef", "Raz", "Zatmenie", "auto", 1);
        User u3 = new User(3, "Jaromir", "Jagr", "fico", "fico", 2);
        User u4 = new User(4, "Marian", "Kocner", "kuco", "zajebat", 2);
        User u5 = new User(5, "Mikulas", "Cernak", "tampa", "bay", 2);

        ArrayList<User> al1 = new ArrayList<>();
        al1.add(u1);
        al1.add(u2);
        ArrayList<User> al2 = new ArrayList<>();
        al2.add(u5);
        al2.add(u1);
        al2.add(u2);
        ArrayList<User> al3 = new ArrayList<>();
        al3.add(u4);
        al3.add(u3);
        al3.add(u1);
        al3.add(u2);


        Group g1 = new Group("Gumkaci", al1);
        Group g2 = new Group("Pelonidas", al2);
        Group g3 = new Group("Špartakus", al3);

        groupsName.setCellValueFactory(new PropertyValueFactory<>("groupName"));
        groupsStudentCount.setCellValueFactory(param -> new SimpleStringProperty(String.valueOf(param.getValue().getStudentList().size())));

        groupsTableView.getItems().setAll(g1, g2, g3);

        groupsTableView.setRowFactory(tv -> {
            TableRow<Group> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY) {
                    Group clickedRow = row.getItem();
                    group = clickedRow;
                    groupTextArea.setText("Group: " + clickedRow.getGroupName());
                    ObservableList<User> ol = FXCollections.observableArrayList();
                    ol.setAll(clickedRow.getStudentList());

                    detailCol.setCellValueFactory(val -> new SimpleStringProperty(val.getValue().getFullName()));
                    groupsDetailTableView.getItems().setAll(ol);

                    deleteGroupButton.setDisable(false);
                    isGroupTableViewClicked = true;
                } else {
                    isGroupTableViewClicked = false;
                }
            });
            return row;
        });
    }

    public void addStudentToGroup(ActionEvent event) {
        if (isGroupTableViewClicked && isStudentsTableViewClicked) {
            group.getStudentList().add(user);
            System.out.println(group.getStudentList());
        }
    }

    private void updateAllTableViews() throws Exception {
//        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
//        tableColumnFName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
//        tableColumnLName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
//        tableViewCitizens.getItems().setAll(mainModel.getAllCitizenFromOneSchool(mainModel.getCurrentSchoolId()));

        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        studentsTableView.getItems().setAll(mainModel.getUsersByRole(mainModel.getRoleId()));

        //TODO Dokoncit ked bude group v db
    }
}
