package DAL;

import DAL.Connector.DBConnector;

import java.io.IOException;

public class FunctionalityStateDAO {

    DBConnector dbConnector;

    public FunctionalityStateDAO() throws IOException {
        dbConnector = DBConnector.getInstance();
    }
    
}
