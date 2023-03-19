package id.choniyuazwan.onion.domain.service;

import id.choniyuazwan.onion.domain.model.User;
import id.choniyuazwan.onion.domain.service.repository.UserRepository;

public class UserService {
  private final UserRepository repository;

  public UserService(UserRepository repository) {
    this.repository = repository;
  }

  public User getUser(String username) {
    return repository.getUser(username);
  }
}
