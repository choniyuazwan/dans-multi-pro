package id.choniyuazwan.onion.infrastructure.rest;

import id.choniyuazwan.onion.infrastructure.rest.dto.CommonResponse;
import id.choniyuazwan.onion.infrastructure.rest.dto.PositionDto;
import id.choniyuazwan.onion.manager.PositionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class PositionRest {
  private static final Logger log = LoggerFactory.getLogger(PositionRest.class);

  @Autowired
  private PositionManager positionManager;

  @GetMapping(value = "/positions")
  public ResponseEntity<CommonResponse<List<PositionDto>>> getListPosition() {
    try {
      CommonResponse<List<PositionDto>> response = new CommonResponse<>();
      List<PositionDto> positionListDto = positionManager.getListPosition();
      response.setData(positionListDto);
      return ResponseEntity.ok(response);
      
    } catch (Exception e) {
      log.error("fail getListPosition", e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @GetMapping(value = "/positions/{id}")
  public ResponseEntity<CommonResponse<PositionDto>> getOnePosition(@PathVariable("id") String id) {
    try {
      CommonResponse<PositionDto> response = new CommonResponse<>();
      PositionDto positionDto = positionManager.getOnePosition(id);
      response.setData(positionDto);
      return ResponseEntity.ok(response);
      
    } catch (Exception e) {
      log.error("fail getOnePosition", e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @GetMapping(value = "/download")
  public ResponseEntity<?> downloadPosition() {
    try {
      String positions = positionManager.downloadPosition();
      
      return ResponseEntity.ok()
              .contentType(MediaType.parseMediaType("application/octet-stream"))
              .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=positions.json")
              .body(positions);
      
    } catch (Exception e) {
      log.error("fail downloadPosition", e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }
}
