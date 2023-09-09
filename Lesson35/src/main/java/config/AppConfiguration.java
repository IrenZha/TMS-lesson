package config;

import domain.Client;
import domain.Horse;
import domain.Jockey;
import domain.Pair;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AppConfiguration {

    @Bean
    public Horse horse1() {
        return new Horse("Horse1");
    }

    @Bean
    public Horse horse2() {
        return new Horse("Horse2");
    }

    @Bean
    public Horse horse3() {
        return new Horse("Horse3");
    }


    @Bean
    public Jockey jockey1() {
        return new Jockey("Jockey1");
    }

    @Bean
    public Jockey jockey2() {
        return new Jockey("Jockey2");
    }

    @Bean
    public Jockey jockey3() {
        return new Jockey("Jockey3");
    }


    @Bean
    public Pair pair1(Horse horse1, Jockey jockey1) {
        return new Pair(horse1, jockey1);
    }

    @Bean
    public Pair pai2(Horse horse2, Jockey jockey2) {
        return new Pair(horse2, jockey2);
    }

    @Bean
    public Pair pair3(Horse horse3, Jockey jockey3) {
        return new Pair(horse3, jockey3);
    }
    @Bean
    public Client client() {
        return new Client(1000);
    }
}
