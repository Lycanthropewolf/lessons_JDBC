package JDBC__lessons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = getConnection()) {

        }

    }

    private static Connection getConnection() throws SQLException {
        final String url = "jdbc:postgresql://localhost:5433/postgres";
        final String user = "postgres";
        final String passvord = "cg7pdrpp";
        return DriverManager.getConnection(url, user, passvord);
    }


}
