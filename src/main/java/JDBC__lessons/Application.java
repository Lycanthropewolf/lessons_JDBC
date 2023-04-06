package JDBC__lessons;

import java.sql.*;

public class Application {
    public static void main(String[] args) throws SQLException {
        String query = "SELECT * FROM employee WHERE id= ?";

        try (Connection connection = getConnection()){
             PreparedStatement statement=connection.prepareStatement(query);
             statement.setInt(1,1);
             ResultSet resultSet = statement.executeQuery();
             while (resultSet.next()) {
                int id = resultSet.getInt(1);
                System.out.println("id = "+id);
                String name = resultSet.getString(2);
                System.out.println("name = "+name);
            }
        }

    }



    private static Connection getConnection() throws SQLException {
        final String url = "jdbc:postgresql://localhost:5433/mybase";
        final String user = "postgres";
        final String passvord = "cg7pdrpp";
        return DriverManager.getConnection(url, user, passvord);
    }


}
