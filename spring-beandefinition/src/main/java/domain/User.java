package domain;
/**
 *  @Description: ref ->{@link Car}
 *  @author: zhao_yd
 *  @Date: 2020/12/22 9:26 上午
 *
 */

public class User {

    private String master;

    private Car car;

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "User{" +
                "master='" + master + '\'' +
                ", car=" + car +
                '}';
    }
}
