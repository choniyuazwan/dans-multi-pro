package id.choniyuazwan.onion.infrastructure.rest;

import java.io.Serializable;

public class UserDTO implements Serializable {
  private String username;
  private String fullname;

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
}
