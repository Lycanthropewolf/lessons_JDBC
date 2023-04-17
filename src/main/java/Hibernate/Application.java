package Hibernate;

import Hibernate.Model.Employee;
import Hibernate.Service.EmployeeDao;
import Hibernate.Service.EmployeeDaoImpl;

public class Application {
    public static void main(String[] args) {
        Employee employee = new Employee(141, "Denis", "Sergeev", "male", 56, 141);
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        employeeDao.getAllEmployee().forEach(System.out::println);
        Integer employeeId = employeeDao.add(employee);
        System.out.println(employeeDao.getAllEmployee());
        System.out.println();
        employeeDao.updateEmployee(employee, employeeId);
        employeeDao.deleteEmployee(employeeDao.getById(employeeId));
        System.out.println(employeeDao.getById(141));

    }


}
