package DAL;

import DAL.Connector.DBConnector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO {


    private DBConnector connector;

    public DAO() throws IOException {
        connector = new DBConnector();
    }

    public void testMethod () {
        try(Connection con = connector.getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employee");
            System.out.println("si gay? " + rs);

            //String readSQL = rs.getNString("Name");
            //System.out.println(readSQL);
        }
        catch (Exception sqle){
            System.out.println("Error: " + sqle);
        }
    }
}
