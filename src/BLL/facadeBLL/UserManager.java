package BLL.facadeBLL;

import BE.User;
import BLL.facadeBLL.utils.LoginUserHelper;
import DAL.facadeDAL.FacadeDAL;

import java.io.IOException;

public class UserManager {
    FacadeDAL facadeDAL;
    LoginUserHelper loginUserHelper;

    public UserManager() throws IOException {
        facadeDAL = new FacadeDAL();
        loginUserHelper = new LoginUserHelper();
    }

    public User compareLogins(String username, String password) throws Exception {
        User user = facadeDAL.compareLogins(username, password);
        if (user != null) return loginUserHelper.getInstance(user);
        else return null;
    }

}
