package Hibernate.Service;

import Hibernate.Model.Employee;

import java.util.List;

public interface EmployeeDao {
    Integer add(Employee employee);

    Employee getById(int id);

    List<Employee> getAllEmployee();

    void updateEmployee(Employee employee, int id);

    void deleteEmployee(Employee employee);
}
