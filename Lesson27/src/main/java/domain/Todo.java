package domain;

import lombok.Data;

import java.util.UUID;

@Data
public class Todo {
    private UUID id;
    private String task;
    Status status;

    public Todo(String task) {
        this.id = UUID.randomUUID();
        this.task = task;
        this.status = Status.CREATED;
    }
}
