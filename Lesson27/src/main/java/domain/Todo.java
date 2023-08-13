package domain;

import lombok.Data;

@Data
public class Todo {
    private String task;
    private String status = "Created";

    public Todo(String task) {
        this.task = task;
    }

    public String getStatus() {
        return status;
    }
}
