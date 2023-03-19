package id.choniyuazwan.onion.infrastructure.rest;

import id.choniyuazwan.onion.domain.model.User;
import id.choniyuazwan.onion.infrastructure.rest.dto.CommonResponse;
import id.choniyuazwan.onion.infrastructure.rest.dto.LoginDto;
import id.choniyuazwan.onion.manager.UserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class UserRest {
  private static final Logger log = LoggerFactory.getLogger(UserRest.class);

  @Autowired
  private UserManager userManager;

  @PostMapping(value = "/login")
  public ResponseEntity<CommonResponse<User>> login(@RequestBody LoginDto loginDto) {
    try {
      CommonResponse<User> response = new CommonResponse<>();

      User user = userManager.login(loginDto.getUsername(), loginDto.getPassword());
      response.setData(user);
      if (user == null) {
        response.setCode("01").setMessage("Failed");
      }
      return ResponseEntity.ok(response);
    } catch (Exception e) {
      log.error("fail login", e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }
}
