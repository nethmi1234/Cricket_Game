package com.cricket.model;

import java.util.Random;

public class Player {

    private String name;
    private int score;
    private String gotOutBy;
    private String wicketType;
    private String status;

    public Player(String name){
        this.name=name;
        this.score=0;
        this.gotOutBy=" ";
        this.wicketType="";
        this.status="NOT_YET_BAT";
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }

    public void setGotOutBy(String gotOutBy){ this.gotOutBy=gotOutBy; }

    public String getGotOutBy(){ return this.gotOutBy; }

    public void setWicketType(String wicketType){ this.wicketType=wicketType; }

    public String getWicketType(){ return this.wicketType; }

    public void setStatus(String status){ this.status=status; }

    public String getStatus(){ return this.status; }

    public void updateScore(int result) {
        this.score += result;
    }

    public int bat(Random random){
        return random.nextInt(8);
    }
}
