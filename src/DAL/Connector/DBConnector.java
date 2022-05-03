package DAL.Connector;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class DBConnector {

    private static final String CONFIG_FILE_NAME = "src/MyLoginFile.cfg";

    private SQLServerDataSource dataSource;

    public DBConnector() throws IOException {
        Properties props = new Properties();
        props.load(new FileReader(CONFIG_FILE_NAME));

        dataSource = new SQLServerDataSource();
        dataSource.setServerName(props.getProperty("SERVER"));
        dataSource.setDatabaseName(props.getProperty("DATABASE"));
        dataSource.setUser(props.getProperty("USER"));
        dataSource.setPassword(props.getProperty("PASSWORD"));
        dataSource.setPortNumber(Integer.parseInt(props.getProperty("PORT")));
    }


    public Connection getConnection() throws Exception {
        return dataSource.getConnection();
    }

}