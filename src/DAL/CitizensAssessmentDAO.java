package DAL;

import DAL.Connector.DBConnector;

import java.io.IOException;

public class CitizensAssessmentDAO {

    DBConnector dbConnector;

    public CitizensAssessmentDAO() throws IOException {
        dbConnector = DBConnector.getInstance();
    }
}
