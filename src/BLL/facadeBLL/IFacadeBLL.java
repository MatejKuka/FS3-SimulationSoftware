package BLL.facadeBLL;

import BE.User;

public interface IFacadeBLL {

    //UserManager
    public User compareLogins(String username, String password) throws Exception;
}
