package id.choniyuazwan.onion.domain.service.repository;

import id.choniyuazwan.onion.infrastructure.rest.dto.PositionDto;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface PositionRepository {
  List<PositionDto> getListPosition() throws NoSuchAlgorithmException, KeyManagementException;

  PositionDto getOnePosition(String id);

  String downloadPosition() throws NoSuchAlgorithmException, KeyManagementException;
}
