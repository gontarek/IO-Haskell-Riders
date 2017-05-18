package io.riders;

import io.riders.models.DiceModel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by mruga on 17.05.2017.
 */
public class DiceTest {
    @Test
    public void testIsInRange(){
        DiceModel dice = DiceModel.throwDice();
        int number = dice.getValue();
        assertTrue( 1 <= number && number <= 6 );
    }
}
