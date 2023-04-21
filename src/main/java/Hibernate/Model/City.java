package Hibernate.Model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class City {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int city_id;
    private String city_name;
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<Employee> employees;

    public City(int city_id, String city_name, List<Employee> employees) {
        this.city_id = city_id;
        this.city_name = city_name;
        this.employees = employees;
    }

    public City() {
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city = (City) o;
        return getCity_id() == city.getCity_id();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity_id());
    }
}
