package BLL;

import BE.User;
import BLL.exeptions.UserException;
import BLL.utils.LoginUserHelper;
import DAL.facadeDAL.FacadeDAL;

import java.io.IOException;

public class LoginManager {
    FacadeDAL facadeDAL;

    public LoginManager() throws IOException {
        facadeDAL = FacadeDAL.getInstance();
    }

    public User compareLogins(String username, String password) throws UserException {
        User user = facadeDAL.compareLogins(username, password);
        if (user != null) return LoginUserHelper.getInstance(user);
        else return null;
    }

}
