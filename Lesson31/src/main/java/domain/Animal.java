package domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import service.HotelService;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String moniker;
    private Integer age;
    private boolean isHealthy;
    @Temporal(TemporalType.DATE)
    private Date date = new Date();
    @Enumerated(EnumType.STRING)
    private HotelService hotelService;
    @Embedded
    Person person;

    public Animal(String name, Integer age, boolean isHealthy, HotelService hotelService, Person person) {
        this.moniker = name;
        this.age = age;
        this.isHealthy = isHealthy;
        this.hotelService = hotelService;
        this.person = person;
    }
}
