package decorator.domain;

import decorator.service.HistoryMassageService;
import decorator.service.MassageService;
import decorator.service.UserMassageService;

public class MainApp {
    public static void main(String[] args) {
        MassageService historyMassageService = new HistoryMassageService(new UserMassageService());
        System.out.println(historyMassageService.send(new User("user1"),"Welcome"));
        System.out.println(historyMassageService.send(new User("user2"),"Welcome"));
        System.out.println(historyMassageService.send(new User("user3"),"Welcome"));
        MassageService userMassageService = new UserMassageService();
        System.out.println(userMassageService.send(new User("user4"),"Welcome"));

    }
}
