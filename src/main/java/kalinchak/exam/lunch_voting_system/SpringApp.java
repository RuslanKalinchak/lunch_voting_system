package kalinchak.exam.lunch_voting_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication (scanBasePackages = {
        "kalinchak.exam.lunch_voting_system.config",
        "kalinchak.exam.lunch_voting_system.dao"
})
public class SpringApp {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder templateBuilder){
        return templateBuilder.build();
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringApp.class, args);
    }
}
