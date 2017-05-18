package io.riders;

import io.riders.models.CoinModel;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by mruga on 17.05.2017.
 */
public class CoinTest {
    @Test
    public void testCoin(){
        CoinModel coin = CoinModel.throwCoin();
        int value = coin.getValue();
        assertTrue(value == 0 || value == 1);
    }
}
