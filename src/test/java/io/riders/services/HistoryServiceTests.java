package io.riders.services;

import io.riders.models.HistoryEntry;
import io.riders.repositories.HistoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by tommy on 5/18/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class HistoryServiceTests {


    @InjectMocks
    private HistoryService historyService = new HistoryServiceImplementation();

    @Mock
    private HistoryRepository historyRepository;

    @Test
    public void testGetById() {
        HistoryEntry historyEntry = new HistoryEntry();
        when(historyRepository.findOne(1)).thenReturn(historyEntry);

        HistoryEntry fetchedHistoryEntry = historyService.getById(1);
        assertTrue(fetchedHistoryEntry == historyEntry);

        verify(historyRepository).findOne(1);
    }

    @Test
    public void testDelete() {

        historyService.delete(1);

        verify(historyRepository).delete(1);
    }

    @Test
    public void testFindAllByUser() {
        when(historyRepository.findAllByUser("user")).thenReturn(new ArrayList<HistoryEntry>());

        List<HistoryEntry> entries = historyService.findAllByUser("user");
        assertTrue(entries.isEmpty());

        verify(historyRepository).findAllByUser("user");
    }

    @Test
    public void testSaveOrUpdate() {
        HistoryEntry historyEntry = new HistoryEntry();
        when(historyRepository.save(historyEntry)).thenReturn(historyEntry);

        HistoryEntry savedHistoryEntry = historyService.saveOrUpdate(historyEntry);
        assertTrue(savedHistoryEntry == historyEntry);

        verify(historyRepository).save(historyEntry);
    }

}
