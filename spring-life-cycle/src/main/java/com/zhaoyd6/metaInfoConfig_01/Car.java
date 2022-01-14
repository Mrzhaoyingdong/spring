package com.zhaoyd6.metaInfoConfig_01;
/**  * All rights Reserved, Designed By zhaoyd.
 *
 * @author: zhaoyd
 * @date: 2021/6/23 21:13
 * @Copyright: ©2020 zhaoyd. All rights reserved.
 * 注意：本内容仅限于自己阅读，禁止外泄以及用于其他的商业用途。
 */
public class Car {

    private String name;

    private String city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

}
