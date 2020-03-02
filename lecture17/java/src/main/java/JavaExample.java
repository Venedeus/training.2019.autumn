import beans.Car;
import beans.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaExample {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("config");

        Person person = context.getBean(Person.class);
        System.out.println(person.hashCode());

        person = context.getBean(Person.class);
        System.out.println(person.hashCode());

        Car car = context.getBean(Car.class);
        System.out.println(car);

        car = context.getBean(Car.class);
        System.out.println(car);
    }
}
