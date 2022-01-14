package domain;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *  @Description: 复合对象
 *  @author: zhao_yd
 *  @Date: 2020/12/22 10:48 上午
 *
 */

public class CompositeObj {

    private String name;
    private Integer salary;

    private Car car;
    private List<String> names;
    private List<Car> cars;

    private Set<String> nameSet;
    private Set<Car> carSet;

    private Map<String,String> mapnames;
    private Map<String,Car> carMap;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public Map<String, String> getMapnames() {
        return mapnames;
    }

    public void setMapnames(Map<String, String> mapnames) {
        this.mapnames = mapnames;
    }

    public Map<String, Car> getCarMap() {
        return carMap;
    }

    public void setCarMap(Map<String, Car> carMap) {
        this.carMap = carMap;
    }

    public Set<String> getNameSet() {
        return nameSet;
    }

    public void setNameSet(Set<String> nameSet) {
        this.nameSet = nameSet;
    }

    public Set<Car> getCarSet() {
        return carSet;
    }

    public void setCarSet(Set<Car> carSet) {
        this.carSet = carSet;
    }

    @Override
    public String toString() {
        return "CompositeObj{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", car=" + car +
                ", names=" + names +
                ", cars=" + cars +
                ", nameSet=" + nameSet +
                ", carSet=" + carSet +
                ", mapnames=" + mapnames +
                ", carMap=" + carMap +
                '}';
    }
}
