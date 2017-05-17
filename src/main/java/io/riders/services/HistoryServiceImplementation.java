package io.riders.services;

import io.riders.models.HistoryEntry;
import io.riders.repositories.HistoryRepository;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class HistoryServiceImplementation implements HistoryService {

  private HistoryRepository historyRepository;

  @Autowired
  public void setHistoryRepository(HistoryRepository historyRepository) {
    this.historyRepository = historyRepository;
  }

  @Override
  public List<?> listAll() {
    return StreamSupport
        .stream(historyRepository.findAll().spliterator(), false)
        .collect(Collectors.toList());
  }

  @Override
  public HistoryEntry getById(Integer id) {
    return historyRepository.findOne(id);
  }

  @Override
  public HistoryEntry saveOrUpdate(HistoryEntry domainObject) {
    return historyRepository.save(domainObject);
  }

  @Override
  public void delete(Integer id) {
    historyRepository.delete(id);
  }

  @Override
  public List<HistoryEntry> findAllByUser(String username) {
    return historyRepository.findAllByUser(username);
  }
}
