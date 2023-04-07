package JDBC__lessons.Service;

import JDBC__lessons.Model.City;
import JDBC__lessons.Model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    final String url = "jdbc:postgresql://localhost:5433/mybase";
    final String user = "postgres";
    final String passvord = "cg7pdrpp";

    @Override
    public void add(Employee employee) throws SQLException {
        try (final Connection connection = DriverManager.getConnection(url, user, passvord);
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO employee (id, first_name, last_name, gender, age, city_id) VALUES ((?),(?),(?),(?),(?),(?))");) {
            statement.setInt(1, employee.getId());
            statement.setString(2, employee.getFirst_name());
            statement.setString(3, employee.getLast_name());
            statement.setString(4, employee.getGender());
            statement.setInt(5, employee.getAge());
            statement.setInt(6, employee.getCity().getCity_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Employee getById(int id) {
        Employee employee = new Employee();

        try (final Connection connection = DriverManager.getConnection(url, user, passvord);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee INNER JOIN city "
                     + "ON employee.city_id = city.city_id WHERE id=(?)")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                employee.setId(resultSet.getInt(1));
                employee.setFirst_name(resultSet.getString(2));
                employee.setLast_name(resultSet.getString(3));
                employee.setGender(resultSet.getString(4));
                employee.setAge(resultSet.getInt(5));
                employee.setCity(new City((resultSet.getInt("city_id")), resultSet.getString("city_name")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employees = new ArrayList<>();
        try (final Connection connection = DriverManager.getConnection(url, user, passvord);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee INNER JOIN city "
                     + "ON employee.city_id = city.city_id")) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = Integer.parseInt(resultSet.getString(1));
                String first_name = resultSet.getString(2);
                String last_name = resultSet.getString(3);
                String gender = resultSet.getString(4);
                int age = Integer.parseInt(resultSet.getString(5));
                City city = new City(resultSet.getInt("city_id"), resultSet.getString("city_name"));
                employees.add(new Employee(id, first_name, last_name, gender, age, city));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(employees);
        return employees;
    }

    @Override
    public void updateEmployee(int id, Employee employee) {
        try (final Connection connection = DriverManager.getConnection(url, user, passvord);
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE employee SET first_name=(?), last_name = (?), gender=(?), age=(?), city_id =(?) WHERE id=(?)")) {
            statement.setString(1, employee.getFirst_name());
            statement.setString(2, employee.getLast_name());
            statement.setString(3, employee.getGender());
            statement.setInt(4, employee.getAge());
            statement.setInt(5, employee.getCity().getCity_id());
            statement.setInt(6, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        try (final Connection connection = DriverManager.getConnection(url, user, passvord);
             PreparedStatement statement = connection.prepareStatement(
                     "DELETE FROM employee WHERE id=(?)")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(getById(id));
    }
}
