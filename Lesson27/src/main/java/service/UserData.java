package service;

import domain.User;

import java.util.HashMap;
import java.util.Map;

public class UserData {
  public static Map<String, User> userMap = new HashMap<>();

    static {
        userMap.put("login1", new User("Ivan", "Ivanov", "login1", "111"));
        userMap.put("login2", new User("Petr", "Petrov", "login2", "222"));
    }

    public static boolean isContains(String login, String password) {
        return (userMap.containsKey(login) && password.equals(userMap.get(login).getPassword()));
    }

}
