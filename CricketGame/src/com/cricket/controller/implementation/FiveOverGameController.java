package com.cricket.controller.implementation;

import com.cricket.controller.GameController;
import com.cricket.model.Player;
import com.cricket.model.Team;

import java.util.Random;
import java.util.Scanner;

public class FiveOverGameController extends GameController {

    public static final String OUT = "OUT";
    public static final String BOWLED = "BOWLED";
    public static final String CAUGHT = "CAUGHT";
    private static final int no_of_overs=5;
    private static final int no_of_balls=3;

    @Override
    protected int bat(Team battingTeam, int targetScore, Scanner scanner) {
        System.out.println("Team "+battingTeam.getName()+" is batting..");

        int totalNoOfBalls = no_of_balls * no_of_overs;

        Random random=new Random();

        Player player=battingTeam.getNextPlayer();

        for (int ball=0; ball<totalNoOfBalls; ball++){
            getUserInputAndValidate(scanner);

            int result = player.bat(random);

            if (result == 5 || result == 7){
                System.out.println("Player "+player.getName()+" is out!");
                player.setStatus(OUT);
                player.setGotOutBy(result==5 ? BOWLED : CAUGHT);

                player = battingTeam.getNextPlayer();

                result = 0; //because the player got out, runs should be zero.

                if (player == null){
                    System.out.println("All out for team "+battingTeam.getName());
                    break;
                }
            }
            else{
                System.out.println( result == 0 ? "Dot Ball" : (result+" runs were scored by player "+player.getName()));
                player.updateScore(result);
            }

            battingTeam.updateScore(result);

            String overs = "(" + ( (ball+1)/3) + "/" +(ball%3) + ")\n";

            String teamSummary = battingTeam.getSummary();

            System.out.println("Score summary : "+ teamSummary+ " " + overs);

            if (ball%3 == 0 && ball!=0){
                System.out.println("End of over!");
            }

            if (targetScore > -1 && battingTeam.getTotalScore() > targetScore){
                break;
            }
        }
        return battingTeam.getTotalScore();
    }
}
