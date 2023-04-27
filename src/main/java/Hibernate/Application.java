package Hibernate;

import Hibernate.Model.City;
import Hibernate.Model.Employee;
import Hibernate.Service.CityDao;
import Hibernate.Service.CityDaoImpl;
import Hibernate.Service.EmployeeDao;
import Hibernate.Service.EmployeeDaoImpl;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        City city = new City(5, "Tomsk", new ArrayList<>());
        CityDao cityDao = new CityDaoImpl();
        Employee employee = new Employee(13, "Denis", "Sergeev", "male", 56, null);
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        /*employeeDao.add(employee);
        List<Employee> list = employeeDao.getAllEmployee();
        for (Employee employee1 : list) {
            System.out.println(employee1);
        }
        employeeDao.deleteEmployee(employee);
        List<Employee> list1 = employeeDao.getAllEmployee();
        for (Employee employee1 : list1) {
            System.out.println(employee1);
        }*/

        /* System.out.println(employeeDao.getById(2));*/

        cityDao.add(city);
        System.out.println();
        cityDao.getById(5);
        System.out.println();
        List<City>listCity=cityDao.getAllCity();
        for (City city1: listCity){
            System.out.println(city1);
        }
    }


}
