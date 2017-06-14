package io.riders.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by mruga on 11.06.2017.
 */
public class SequenceModel {
    private List<Integer> sequence = new ArrayList<>();
    public SequenceModel(Integer lenght){
        for (int i = 0; i < lenght; i++) {
            sequence.set(i,i);
        }
        Collections.shuffle(sequence, new Random(5));
    }
    public List<Integer> getValue(){
        return sequence;
    }
}
