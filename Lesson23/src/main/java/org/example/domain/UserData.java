package org.example.domain;

import lombok.Getter;
import org.example.exception.LoginIsNullException;
import org.example.exception.UserLoginFailedException;

import java.util.HashMap;
import java.util.Map;

@Getter
public class UserData {
    static Map<String, User> userMap = new HashMap<>();

    public boolean checkExistUser(String login, String password) {
        if (login == null || login.isBlank() || password == null || password.isBlank()) {
            throw new LoginIsNullException();
        }
        return  userMap.containsKey(login);
    }

    public void addUser(String login, String password) {
        if(!checkExistUser(login, password)){
        User user = new User(login, password);
        userMap.put(login, user);
    }
}

    public boolean checkPassword(String login, String password) {
        if (checkExistUser(login,password)) {
            User user = userMap.get(login);
            if (password.equals(user.getPassword())) {
                return true;
            }
        }
        throw new UserLoginFailedException();
    }
}
