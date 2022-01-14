package domain;
/**
 *  @Description: 自定义类
 *  @author: zhao_yd
 *  @Date: 2020/12/21 8:30 下午
 *
 */

public class Car {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                '}';
    }
}
