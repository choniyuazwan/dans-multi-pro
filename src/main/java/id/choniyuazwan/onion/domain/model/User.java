package id.choniyuazwan.onion.domain.model;

public class User {
  private String username;
  private String fullname;
  private UserCredential password;

  public User() {
  }

  public User(String username, String fullname, UserCredential password) {
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

  public UserCredential getPassword() {
    return password;
  }

  public void setPassword(UserCredential password) {
    this.password = password;
  }
}
