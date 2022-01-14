package domain;
/**
 *  @Description:
 *  @author: zhao_yd
 *  @Date: 2020/12/21 8:42 下午
 *
 */

public class House {

    private String master;

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    @Override
    public String toString() {
        return "House{" +
                "master='" + master + '\'' +
                '}';
    }
}
