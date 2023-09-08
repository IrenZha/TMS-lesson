import domain.Client;
import domain.Horse;
import domain.Jockey;
import domain.Pair;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.ClientService;
import service.Hippodrome;
import service.RunService;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
       // ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        ApplicationContext context = new AnnotationConfigApplicationContext("config", "domain", "service");
        Hippodrome hippodrome = context.getBean(Hippodrome.class);
        hippodrome.game();
    }
}
