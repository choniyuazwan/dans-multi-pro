package id.choniyuazwan.onion.infrastructure.helper;

import id.choniyuazwan.onion.domain.service.repository.PositionRepository;
import id.choniyuazwan.onion.infrastructure.rest.dto.PositionDto;
import id.choniyuazwan.onion.infrastructure.springboot.SSLUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class PositionHelper implements PositionRepository {
  private static final Logger log = LoggerFactory.getLogger(PositionHelper.class);

  public final RetryTemplate retryTemplate;
  public final RestTemplate restTemplate = new RestTemplate();
  
  public PositionHelper(RetryTemplate retryTemplate) {
    this.retryTemplate = retryTemplate;
  }

  @Override
  public List<PositionDto> getListPosition() throws NoSuchAlgorithmException, KeyManagementException {
    String uri = "https://dev3.dansmultipro.co.id/api/recruitment/positions.json";

    SSLUtil.turnOffSslChecking();
    ResponseEntity<List<PositionDto>> response = retryTemplate.execute(context -> {
      log.info("Hit endpoint : {}", uri);

      return restTemplate.exchange(uri,
              HttpMethod.GET,
              null,
              new ParameterizedTypeReference<>(){});
    }, context -> {
      log.info("Failed hit endpoint : {}, with error : {}", uri, context.toString());
      return null;
    });

    return response.getBody();
  }

  @Override
  public PositionDto getOnePosition(String id) {
    RetryTemplate retryTemplate = new RetryTemplate();
    RestTemplate restTemplate = new RestTemplate();

    String uri = "http://dev3.dansmultipro.co.id/api/recruitment/positions/" + id;
    ResponseEntity<PositionDto> response = retryTemplate.execute(context -> {
      log.info("Hit endpoint : {}", uri);

      return restTemplate.exchange(uri,
              HttpMethod.GET,
              null,
              new ParameterizedTypeReference<>(){});
    }, context -> {
      log.info("Failed hit endpoint : {}, with error : {}", uri, context.toString());
      return null;
    });
    return response.getBody();
  }

  @Override
  public String downloadPosition() throws NoSuchAlgorithmException, KeyManagementException {
    String uri = "https://dev3.dansmultipro.co.id/api/recruitment/positions.json";

    SSLUtil.turnOffSslChecking();
    ResponseEntity<String> response = retryTemplate.execute(context -> {
      log.info("Hit endpoint : {}", uri);

      return restTemplate.exchange(uri,
              HttpMethod.GET,
              null,
              new ParameterizedTypeReference<>(){});
    }, context -> {
      log.info("Failed hit endpoint : {}, with error : {}", uri, context.toString());
      return null;
    });

    return response.getBody();
  }
}
