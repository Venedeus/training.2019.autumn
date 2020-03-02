import beans.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class XMLExample {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Person person1 = context.getBean(Person.class);
        System.out.println(person1);

//        Person person2 = (Person) context.getBean("person2");
//        System.out.println(person2);
    }
}
