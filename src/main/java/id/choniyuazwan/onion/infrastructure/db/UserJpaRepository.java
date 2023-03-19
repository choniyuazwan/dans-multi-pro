package id.choniyuazwan.onion.infrastructure.db;

import id.choniyuazwan.onion.domain.model.User;
import id.choniyuazwan.onion.domain.model.UserCredential;
import id.choniyuazwan.onion.domain.service.repository.UserRepository;
import id.choniyuazwan.onion.infrastructure.db.model.UserCredentialEntity;
import id.choniyuazwan.onion.infrastructure.db.model.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserJpaRepository extends CrudRepository<UserEntity, Integer>, UserRepository {

  @Query
  UserEntity findByUsername(@Param("username") String username);

  default User getUser(String username) {
    UserEntity userEntity = findByUsername(username) == null ? new UserEntity() : findByUsername(username);
    UserCredentialEntity credentialEntity = userEntity.getPassword();
    UserCredential credential = new UserCredential(credentialEntity.getId(), credentialEntity.getPassword());
    return new User(userEntity.getUsername(), userEntity.getFullname(), credential);
  }
}
