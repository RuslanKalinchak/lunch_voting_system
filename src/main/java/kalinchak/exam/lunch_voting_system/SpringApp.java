package kalinchak.exam.lunch_voting_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication (scanBasePackages = {
        "kalinchak.exam.lunch_voting_system.config",
        "kalinchak.exam.lunch_voting_system.dao"
})
public class SpringApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringApp.class, args);
    }
}
