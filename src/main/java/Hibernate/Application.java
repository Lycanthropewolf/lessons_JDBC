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
        City city=new City(5,"Tomsk",new ArrayList<>());
        CityDao cityDao=new CityDaoImpl();
        Employee employee = new Employee(13, "Denis", "Sergeev", "male", 56, city);
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        employeeDao.deleteEmployee(employee);
        /* System.out.println(employeeDao.getById(2));*/
        List<Employee> list = employeeDao.getAllEmployee();
        for (Employee employee1 : list) {
            System.out.println(employee1);
        }
        cityDao.add(city);
        List<City> list1=cityDao.getAllCity();
        for (City city1:list1){
            System.out.println(city1);
        }

    }


}
