package service;

import config.MailRefreshConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MailService {

    @Autowired
    private MailRefreshConfig mailRefreshConfig;


    @Override
    public String toString() {
        return "MailService{" +
                "mailRefreshConfig=" + mailRefreshConfig +
                '}';
    }
}
