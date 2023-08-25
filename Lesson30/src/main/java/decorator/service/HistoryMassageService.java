package decorator.service;

import decorator.domain.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HistoryMassageService implements MassageService {
    private MassageService massageService;
    private Date date;
    private List<String> history;

    public HistoryMassageService(MassageService massageService) {
        this.massageService = massageService;
        this.date = new Date();
        this.history = new ArrayList<>();
    }

    @Override
    public String send(User user, String massage) {
        massageService.send(user, massage);
        String userMassage = user.getId() + "  :   Hello " + user.getName() + "! " + massage + "  :  " + date;
        history.add(userMassage);
        return userMassage;
    }
}
