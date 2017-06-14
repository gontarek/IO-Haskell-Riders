package io.riders.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Model for random Lotto series (6 digits 1 through 49)
 */
public class LottoModel {
    private List<Integer> lotto_numbers = new ArrayList<>();

    public LottoModel(){
        for (int i = 0; i < 48; i++)
            lotto_numbers.add(i,i+1);
        Collections.shuffle(lotto_numbers, new Random(ThreadLocalRandom.current().nextInt()));
        lotto_numbers = lotto_numbers.subList(0,6);
        Collections.sort(lotto_numbers);
    }

    public List<Integer> getValue(){
        return lotto_numbers;
    }
}
