package ru.dex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.dex.domain.Demo;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        Demo bean = applicationContext.getBean(Demo.class);
        bean.start();
    }
}
