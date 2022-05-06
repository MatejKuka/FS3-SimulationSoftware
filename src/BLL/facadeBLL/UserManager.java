package BLL.facadeBLL;

import BE.User;
import DAL.facadeDAL.FacadeDAL;

import java.io.IOException;

public class UserManager {
    FacadeDAL facadeDAL;

    public UserManager() throws IOException {
        facadeDAL = new FacadeDAL();
    }

    public User compareLogins(String username, String password) throws Exception {
        return facadeDAL.compareLogins(username, password);
    }

}
