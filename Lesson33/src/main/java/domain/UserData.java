package domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.*;

@Data
@NoArgsConstructor
@Entity
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userName;

    @Enumerated(EnumType.STRING)
    private TypeUser type;
    private boolean isMan;

    @Temporal(TemporalType.DATE)
    private Date birthday;

    @OneToMany(mappedBy = "userData")
    @ToString.Exclude
    private List<Task> tasks;

    public UserData(String userName, TypeUser type, boolean isMan, Date birthday) {
        this.userName = userName;
        this.type = type;
        this.isMan = isMan;
        this.birthday = birthday;
        this.tasks = new ArrayList<>();
    }

    public void setTask(Task task) {
        this.setTasks(List.of(task));
        task.setUserData(this);
    }
}
