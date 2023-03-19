package id.choniyuazwan.onion.domain.service.repository;

import id.choniyuazwan.onion.domain.model.User;

public interface UserRepository {
  User getUser(String username);
}
