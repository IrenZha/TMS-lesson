package decorator.service;

import decorator.domain.User;

public interface MassageService {
    String send(User user, String massage);
}
