package DAL;

import DAL.Connector.DBConnector;

import java.io.IOException;

public class HealthConditionsDAO {

    DBConnector dbConnector;

    public HealthConditionsDAO() throws IOException {
        dbConnector = DBConnector.getInstance();
    }
    
}
