package id.choniyuazwan.onion.infrastructure.db.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {
  @Id
  @Column
  private String username;
  @Column
  private String fullname;

  @ManyToOne
  @JoinColumn(name = "password")
  private UserCredentialEntity password;

  public void setPassword(UserCredentialEntity password) {
    this.password = password;
  }

  public UserEntity() {

  }

  public UserEntity(String username, String fullname, UserCredentialEntity password) {
    this.username = username;
    this.fullname = fullname;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getFullname() {
    return fullname;
  }

  public void setFullname(String fullname) {
    this.fullname = fullname;
  }

  public UserCredentialEntity getPassword() {
    return password;
  }

}

