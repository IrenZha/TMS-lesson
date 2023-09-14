
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.Hippodrome;

public class MainApp {
    public static void main(String[] args) {
       // ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        ApplicationContext context = new AnnotationConfigApplicationContext("config", "domain", "service", "aspect");
        Hippodrome hippodrome = context.getBean(Hippodrome.class);
        hippodrome.game();
    }
}
