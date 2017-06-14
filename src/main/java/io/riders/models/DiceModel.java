package io.riders.models;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Model for a random dice throw
 */
public class DiceModel {
    private final int value;

    public static DiceModel throwDice() {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 6 + 1);
        return new DiceModel(randomNum);
    }

    private DiceModel(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
