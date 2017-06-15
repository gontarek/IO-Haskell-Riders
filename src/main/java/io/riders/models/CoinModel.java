package io.riders.models;

/**
 * Model for dice throw
 */
public class CoinModel {
    private final int value;

    private CoinModel() {
        this.value = (int) Math.round(Math.random());
    }

    public static CoinModel throwCoin(){
        return new CoinModel();
    }

    public int getValue() {
        return value;
    }
}
