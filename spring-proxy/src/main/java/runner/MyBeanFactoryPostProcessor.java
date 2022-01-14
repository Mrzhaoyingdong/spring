package runner;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {


    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
//        AbstractApplicationContext bean = beanFactory.getBean(AbstractApplicationContext.class);
//        Map<String, Object> mailInfoFromDb = DbUtil.getMailInfoFromDb();
//        MapPropertySource mapPropertySource = new MapPropertySource("mail",mailInfoFromDb);
//        bean.getEnvironment().getPropertySources().addFirst(mapPropertySource);

    }
}
