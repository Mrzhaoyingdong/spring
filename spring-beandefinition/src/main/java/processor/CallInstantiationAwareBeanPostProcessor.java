package processor;


import domain.Car;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.lang.NonNull;

/**
 *  @Description: 自定义Processor {@link InstantiationAwareBeanPostProcessor}
 *  @author: zhao_yd
 *  @Date: 2020/12/24 8:13 下午
 *
 */

public class CallInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    @Override
    @NonNull
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if(null != beanClass && beanClass == Car.class){
            System.out.println("调用 postProcessBeforeInstantiation() 方法");
            Car car = new Car();
            car.setName("保时捷911");
            return car;
        }
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if("user1".equals(beanName)){
            return false;
        }
        return true;
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        if("zyd".equals(beanName)){
            MutablePropertyValues mpvs = (MutablePropertyValues) pvs;
            mpvs.add("name","zyd");
            mpvs.add("age",100);
//            if(pvs == null){
//                pvs = new MutablePropertyValues();
//                if(pvs instanceof  MutablePropertyValues){
//                    MutablePropertyValues mpvs = (MutablePropertyValues) pvs;
//                    mpvs.add("name","zyd");
//                    mpvs.add("age",100);
//                   // return mpvs;
//                }
//            }
        }
        return null;
    }
}
