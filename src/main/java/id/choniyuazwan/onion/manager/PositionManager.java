package id.choniyuazwan.onion.manager;

import id.choniyuazwan.onion.domain.service.PositionService;
import id.choniyuazwan.onion.infrastructure.rest.dto.PositionDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PositionManager {
  private static final Logger log = LoggerFactory.getLogger(PositionManager.class);

  public final PositionService positionService;
  
  public PositionManager(PositionService positionService) {
    this.positionService = positionService;
  }
  
  public List<PositionDto> getListPosition() throws NoSuchAlgorithmException, KeyManagementException {
    List<PositionDto> positionList = positionService.getListPosition();
    
    Map<String, List<PositionDto>> locationMap = new HashMap<>();
    for (PositionDto data : positionList) {
      String location = data.getLocation();
      if (!locationMap.containsKey(location)) {
        locationMap.put(location, new ArrayList<>());
      }
      locationMap.get(location).add(data);
    }
    
    for (String location : locationMap.keySet()) {
      System.out.println("Location: " + location);
      List<PositionDto> locationDataList = locationMap.get(location);
      for (PositionDto data : locationDataList) {
        System.out.println("\t" + data.getId() + " - " + data.getType());
      }
    }
    
    return positionList;
  }

  public PositionDto getOnePosition(String id) {
    return positionService.getOnePosition(id);
  }

  public String downloadPosition() throws NoSuchAlgorithmException, KeyManagementException {
    return positionService.downloadPosition();
  }
}
