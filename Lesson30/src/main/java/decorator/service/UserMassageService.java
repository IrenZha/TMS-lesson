package decorator.service;

import decorator.domain.User;

public class UserMassageService implements MassageService {

    @Override
    public String send(User user, String massage) {
      return  "Hello " + user.getName() + "! " + massage;
    }
}
