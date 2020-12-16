package bstorm.akim.correctionExo3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Scanner;

@Configuration
@Profile("console")
public class AppConfig {

    @Bean
    public Scanner scanner(){
        return new Scanner(System.in);
    }
}
