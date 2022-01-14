package domain;
/**
 *  @Description: 用户模型
 *  @author: zhao_yd
 *  @Date: 2020/12/24 7:55 下午
 *
 */

public class UserModel {

    private String name;
    private Integer age;

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
        return "UserModel{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
