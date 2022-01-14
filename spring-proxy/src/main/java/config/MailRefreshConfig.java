package config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class MailRefreshConfig {

    @Value("${mail.username}")
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "MailRefreshConfig{" +
                "username='" + username + '\'' +
                '}';
    }
}
