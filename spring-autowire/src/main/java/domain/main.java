package domain;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {

    public static void main(String[] args) {
        String beanXml = "classpath:/META-INF/autowireCandidateBean.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml);
        context.refresh();
        System.out.println(context.getBean(SetterBean.class).toString()); //@1

        SetterBean.IService service = context.getBean(SetterBean.IService.class); //@2
        //System.out.println(service);



        context.close();

    }
}
