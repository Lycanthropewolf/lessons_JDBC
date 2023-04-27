package Hibernate.Model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class City {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private int cityId;
    @Column(name = "city_name")
    private String cityName;
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<Employee> employees;

    public City(int city_id, String city_name, List<Employee> employees) {
        this.cityId = city_id;
        this.cityName = city_name;
        this.employees = employees;
    }

    public City() {
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int city_id) {
        this.cityId = city_id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String city_name) {
        this.cityName = city_name;
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
        return getCityId() == city.getCityId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCityId());
    }
}
