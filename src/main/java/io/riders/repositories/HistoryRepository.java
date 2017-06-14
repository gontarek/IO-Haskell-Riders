package io.riders.repositories;

import io.riders.models.HistoryEntry;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 * Database repository for History Entries
 */
public interface HistoryRepository extends CrudRepository<HistoryEntry, Integer> {

  /**
   * Find a history entries (random events) in database given a username
   * @param username user for which the entries are found
   * @return a list of all events with given usernames
   */
  List<HistoryEntry> findAllByUser(String username);
}
