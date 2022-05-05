package DAL;

import DAL.Connector.DBConnector;

import java.io.IOException;

public class CitizenDAO {
    private DBConnector dbConnector;

    public CitizenDAO() throws IOException {
        this.dbConnector = DBConnector.getInstance();
    }


}
