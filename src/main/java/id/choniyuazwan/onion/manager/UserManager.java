package id.choniyuazwan.onion.manager;

import id.choniyuazwan.onion.domain.model.User;
import id.choniyuazwan.onion.domain.service.UserService;

public class UserManager {

  private final UserService userService;

  public UserManager(UserService userService) {
    this.userService = userService;
  }
  
  public User login(String username, String password) {
    User user = userService.getUser(username);

    return user != null && user.getPassword().getPassword().equals(password) ? user : null;
  }
}
