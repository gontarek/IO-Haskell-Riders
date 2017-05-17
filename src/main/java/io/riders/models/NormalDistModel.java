package io.riders.models;

import java.util.Random;

/**
 * Created by mruga on 18.05.2017.
 */
public class NormalDistModel {
    double nextNumber(long seed, int iter){
        Random rand = new Random(seed);
        double normal = rand.nextGaussian();
        for(int i=0;i<iter;i++)
            normal = rand.nextGaussian();
        return normal;

    }
}
