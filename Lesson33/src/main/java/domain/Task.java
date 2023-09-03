package domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Version
    private Integer version;

    private String title;
    private String description;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date date;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @ToString.Exclude
    private UserData userData;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.status = Status.NEW;
    }
    @PrePersist
    public void prePersist() {
        System.out.println("prePersist");
    }

    @PostPersist
    public void postPersist() {
        System.out.println("postPersist");
    }
}
