package JDBC__lessons.Service;

import JDBC__lessons.Model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {
    void add(Employee employee) throws SQLException;

    Employee getById(int id);

    List<Employee> getAllEmployee();

    void updateEmployee(int id, Employee employee);

    void deleteEmployee(int id);
}
