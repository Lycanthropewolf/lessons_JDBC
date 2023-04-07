package JDBC__lessons;

import java.sql.*;

public class Application {
    public static void main(String[] args) throws SQLException {
        final String url = "jdbc:postgresql://localhost:5433/mybase";
        final String user = "postgres";
        final String passvord = "cg7pdrpp";
        try (final Connection connection = DriverManager.getConnection(url, user, passvord);
             PreparedStatement statement = connection.prepareStatement("" + "SELECT * FROM employee WHERE id=(?)")) {
            statement.setInt(1, 4);
            final ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                String name="Name: "+resultSet.getString("first_name");
                String surname="Surname: "+resultSet.getString("last_name");
                String gender="Gender: "+resultSet.getString("gender");
                int age=resultSet.getInt(5);

                System.out.println(name);
                System.out.println(surname);
                System.out.println(gender);
                System.out.println(age);

            }
        }

    }
}
