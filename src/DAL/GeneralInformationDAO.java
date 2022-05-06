package DAL;

import DAL.Connector.DBConnector;

import java.io.IOException;

public class GeneralInformationDAO {
    DBConnector dbConnector;

    public GeneralInformationDAO() throws IOException {
        dbConnector = DBConnector.getInstance();
    }
}
