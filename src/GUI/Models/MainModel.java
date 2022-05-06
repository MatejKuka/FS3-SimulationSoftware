package GUI.Models;

import BE.User;
import BLL.facadeBLL.FacadeBLL;

import java.io.IOException;

public class MainModel {

FacadeBLL manager;

    public MainModel() throws IOException {
        manager = new FacadeBLL();
    }

    public User compareLogins(String username, String password) throws Exception {
        return manager.compareLogins(username, password);
    }





}
