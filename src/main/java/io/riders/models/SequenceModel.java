package io.riders.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by mruga on 11.06.2017.
 */
public class SequenceModel {
    private List<Integer> sequence = new ArrayList<>();

    public SequenceModel(int length){
        for (int i = 0; i < length; i++) {
            sequence.add(i,i);
        }
        Collections.shuffle(sequence, new Random(ThreadLocalRandom.current().nextInt()));
    }

    public List<Integer> getValue(){
        return sequence;
    }
}
