package BLL.facadeBLL;

import BE.User;

import java.io.IOException;

public class FacadeBLL implements IFacadeBLL{
    UserManager userManager;

    public FacadeBLL() throws IOException {
        userManager = new UserManager();
    }

    @Override
    public User compareLogins(String username, String password) throws Exception {
        return userManager.compareLogins(username, password);
    }
}
