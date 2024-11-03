package org.example.Logic.Utils;

public class Scoreboard {
    private static int score = 0;

    public static void countScore(int value){
        score += value;
    }

    public static int getScore(){
        return score;
    }
}
