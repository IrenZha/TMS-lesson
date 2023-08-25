package domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class User {
    private String firstName;
    private String lastName;
    private String login;
    private String password;
   List<Todo> todoList;

    public User(String firstName, String lastName, String login, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        todoList = new ArrayList<>();
    }

    public void addTodoList(Todo todo) {
        todoList.add(todo);
    }

}
