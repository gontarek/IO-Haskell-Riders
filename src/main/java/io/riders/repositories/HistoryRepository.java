package io.riders.repositories;

import io.riders.models.HistoryEntry;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface HistoryRepository extends CrudRepository<HistoryEntry, Integer> {
  List<HistoryEntry> findAllByUser(String username);
}
