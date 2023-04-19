package Hibernate;

import Hibernate.Model.Employee;
import Hibernate.Service.EmployeeDao;
import Hibernate.Service.EmployeeDaoImpl;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Employee employee = new Employee(13, "Denis", "Sergeev", "male", 56, 3);
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        employeeDao.deleteEmployee(employee);
        /* System.out.println(employeeDao.getById(2));*/
        List<Employee> list = employeeDao.getAllEmployee();
        for (Employee employee1 : list) {
            System.out.println(employee1);
        }

    }


}
