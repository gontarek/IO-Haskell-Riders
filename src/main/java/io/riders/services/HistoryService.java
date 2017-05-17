package io.riders.services;

import io.riders.models.HistoryEntry;
import java.util.List;

public interface HistoryService extends CRUDService<HistoryEntry> {
  List<HistoryEntry> findAllByUser(String username);
}
