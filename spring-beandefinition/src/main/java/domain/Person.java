package domain;


import annotation.CallThisConstructer;

/**
 *  @Description: 用户类
 *  @author: zhao_yd
 *  @Date: 2020/12/24 4:26 下午
 *
 */

public class Person {

    private String name;
    private Integer age;

    public Person() {
        System.out.println("call Person()");
    }

    @CallThisConstructer
    public Person(String name) {
        System.out.println("call Person(name)");
        this.name = name;
        this.age = 999;
    }

    @CallThisConstructer
    public Person(String name, Integer age) {
        System.out.println("call Person(name,age)");
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
