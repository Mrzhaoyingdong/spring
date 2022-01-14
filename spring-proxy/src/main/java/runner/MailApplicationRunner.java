package runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MailApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("============");
        System.out.println("name = "+ args.getOptionNames());
        System.out.println("values ==== " + args.getOptionValues("developer.name"));
        System.out.println("values ==== " + args.getOptionValues("value"));
        System.out.println("=============MyApplicationRunner");
    }
}
