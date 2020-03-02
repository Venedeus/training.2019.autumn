import beans.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationExample {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("beans");

        Person person = context.getBean(Person.class);

        person.setId(2);
        person.setName("Evgeniy");
        person.setAge(32);

        System.out.println(person);
    }
}
