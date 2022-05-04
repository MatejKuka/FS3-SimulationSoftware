package DAL;

import BE.User;
import DAL.Connector.DBConnector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDAO {


    private DBConnector connector;

    public UserDAO() throws IOException {
        connector = new DBConnector();
    }

    public User compareLogins(String username, String password) throws Exception
    {
        User user = null;

        try (Connection con = connector.getConnection()) {
            String sql ="SELECT [loginName],[password],[email],[roleID],[userID] FROM LoginUser WHERE [loginName] = ? AND [password] = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next())
            {
                int userID = rs.getInt("userID");
                String loginName = rs.getString("loginName");
                String email = rs.getString("email");
                int roleID = rs.getInt("roleID");

                user = null; // change this
            }
        }
        catch (Exception e)
        {
            user =null;
            e.printStackTrace();
        }
        return user;
    } // TODO Matej - this method needs to be changed
}
