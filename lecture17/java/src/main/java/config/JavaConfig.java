package config;

import beans.Car;
import beans.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class JavaConfig {
    @Bean
    public Person getPerson() {
        return new Person(1, "Evgeniy", 32);
    }

//    @Bean
//    public Person getPerson1() {
//        return new Person(1, "Evgeniy", 32);
//    }

    @Bean
    @Scope("prototype")
    public Car getCar() {
        Car car = new Car();
        car.setModel("Jiguli");

        return car;
    }
}
