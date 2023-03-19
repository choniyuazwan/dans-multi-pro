package id.choniyuazwan.onion.manager;

import id.choniyuazwan.onion.domain.service.PositionService;
import id.choniyuazwan.onion.infrastructure.rest.dto.PositionDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class PositionManager {
  private static final Logger log = LoggerFactory.getLogger(PositionManager.class);

  public final PositionService positionService;
  
  public PositionManager(PositionService positionService) {
    this.positionService = positionService;
  }
  
  public List<PositionDto> getListPosition() throws NoSuchAlgorithmException, KeyManagementException {
    return positionService.getListPosition();
  }

  public PositionDto getOnePosition(String id) {
    return positionService.getOnePosition(id);
  }

  public String downloadPosition() throws NoSuchAlgorithmException, KeyManagementException {
    return positionService.downloadPosition();
  }
}
