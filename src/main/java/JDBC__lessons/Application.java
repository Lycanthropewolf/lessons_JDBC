package JDBC__lessons;

import JDBC__lessons.Model.City;
import JDBC__lessons.Model.Employee;
import JDBC__lessons.Service.EmployeeDao;
import JDBC__lessons.Service.EmployeeDaoImpl;

import java.sql.*;

public class Application {
    public static void main(String[] args) throws SQLException {
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        City city=new City(5,"Moscow");
        Employee employee = new Employee(12,"ffef", "fewfw", "wfwf", 52, city);

        employeeDao.add(employee);












        final String url = "jdbc:postgresql://localhost:5433/mybase";
        final String user = "postgres";
        final String passvord = "cg7pdrpp";


        try (final Connection connection = DriverManager.getConnection(url, user, passvord);
             PreparedStatement statement = connection.prepareStatement("" + "SELECT * FROM employee WHERE id=(?)")) {
            statement.setInt(1, 11);
            final ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = "Name: " + resultSet.getString("first_name");
                String surname = "Surname: " + resultSet.getString("last_name");
                String gender = "Gender: " + resultSet.getString("gender");
                int age = resultSet.getInt(5);

                System.out.println(name);
                System.out.println(surname);
                System.out.println(gender);
                System.out.println(age);

            }
        }

    }
}
