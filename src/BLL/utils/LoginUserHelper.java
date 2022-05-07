package BLL.utils;

import BE.User;

public class LoginUserHelper {


    private static User user;

    public LoginUserHelper() {}

    public static User getInstance(User theUser)
    {
        if(user==null)
        {
            user = theUser;
        }
        return user;
    }
}
