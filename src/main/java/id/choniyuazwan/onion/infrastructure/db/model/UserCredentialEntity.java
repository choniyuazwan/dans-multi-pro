package id.choniyuazwan.onion.infrastructure.db.model;

import javax.persistence.*;

@Entity
@Table(name = "user_credentials")
public class UserCredentialEntity {

  public UserCredentialEntity() {

  }

  public UserCredentialEntity(String password) {
    this.password = password;
  }

  public UserCredentialEntity(Integer id, String password) {
    this.id = id;
    this.password = password;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private Integer id;
  @Column
  private String password;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
