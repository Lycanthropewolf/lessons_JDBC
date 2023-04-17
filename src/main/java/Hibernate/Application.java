package Hibernate;

import Hibernate.Model.Employee;
import Hibernate.Service.EmployeeDao;
import Hibernate.Service.EmployeeDaoImpl;

public class Application {
    public static void main(String[] args) {
        Employee employee = new Employee(134, "Denis", "Sergeev", "male", 56, 3);
        EmployeeDao employeeDao = new EmployeeDaoImpl();

        System.out.println(employeeDao.getById(1));
        System.out.println(employeeDao.add(employee));
        System.out.println(employeeDao.getAllEmployee());
        employeeDao.updateEmployee(employee,100);
        System.out.println(employeeDao.getById(100));
        employeeDao.deleteEmployee(employee);
    }


}
