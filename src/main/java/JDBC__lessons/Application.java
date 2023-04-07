package JDBC__lessons;

import JDBC__lessons.Model.City;
import JDBC__lessons.Model.Employee;
import JDBC__lessons.Service.EmployeeDao;
import JDBC__lessons.Service.EmployeeDaoImpl;

import java.sql.*;

public class Application {
    public static void main(String[] args) throws SQLException {
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        City city = new City(5, "Moscow");
        Employee employee = new Employee(12, "ffef", "fewfw", "wfwf", 52, city);


        employeeDao.getById(3);
        System.out.println();
        employeeDao.getAllEmployee();
        System.out.println();
        employeeDao.updateEmployee(12,employee);
        System.out.println();
        employeeDao.deleteEmployee(12);


        final String url = "jdbc:postgresql://localhost:5433/mybase";
        final String user = "postgres";
        final String passvord = "cg7pdrpp";


    }
}
