package id.choniyuazwan.onion.domain.service;

import id.choniyuazwan.onion.domain.service.repository.PositionRepository;
import id.choniyuazwan.onion.infrastructure.rest.dto.PositionDto;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class PositionService {
  private final PositionRepository repository;

  public PositionService(PositionRepository repository) {
    this.repository = repository;
  }

  public List<PositionDto> getListPosition() throws NoSuchAlgorithmException, KeyManagementException {
    return repository.getListPosition();
  }

  public PositionDto getOnePosition(String id) {
    return repository.getOnePosition(id);
  }

  public String downloadPosition() throws NoSuchAlgorithmException, KeyManagementException {
    return repository.downloadPosition();
  }
}
