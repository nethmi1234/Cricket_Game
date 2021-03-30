package com.cricket.model;

import java.util.Random;

public class SuperPlayer extends Player {

    private int minScore;

    public SuperPlayer(String name, int minScore) {
        super(name);
        this.minScore=minScore;
    }

    public int getMinScore(){
        return this.minScore;
    }

    @Override
    public int bat(Random random) {
        int result = random.nextInt(8);

        while (result < this.minScore){
            result = random.nextInt(8);
        }
        return result;
    }
}
