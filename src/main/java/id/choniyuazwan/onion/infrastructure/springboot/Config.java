package id.choniyuazwan.onion.infrastructure.springboot;

import id.choniyuazwan.onion.domain.service.PositionService;
import id.choniyuazwan.onion.domain.service.UserService;
import id.choniyuazwan.onion.domain.service.repository.PositionRepository;
import id.choniyuazwan.onion.domain.service.repository.UserRepository;
import id.choniyuazwan.onion.manager.PositionManager;
import id.choniyuazwan.onion.manager.UserManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
  @Bean
  public UserService userService(UserRepository repository) {
    return new UserService(repository);
  }

  @Bean
  public UserManager userManager(UserService userService) {
    return new UserManager(userService);
  }

  @Bean
  public PositionService positionService(PositionRepository repository) {
    return new PositionService(repository);
  }

  @Bean
  public PositionManager positionManager(PositionService positionService) {
    return new PositionManager(positionService);
  }
}
