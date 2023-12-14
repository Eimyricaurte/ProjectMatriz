package logic;

import java.util.Random;

public class HandlingMatriz {

    private String[] candidates;
    private String[] cities;
    private int[][] votes;

    public HandlingMatriz() {
    }

    private void loadElements(int begin, int end){

        int min = begin <= end ? begin : end;
        int max = begin >= end ? begin : end;
        for (int i = 0; i < votes.length ; i++){
            for (int j = 0; j < votes[i].length; j++){
                votes[i][j] = new Random().nextInt(max-min+1) + min;
            }
        }
    }

    public String winnerCandidat(){
        return null;
    }

    public String[] elections(){
        return null;
    }

    public int sumVotes(){
        return 0;
    }

    public String[][] findCandidat(String candidat){
        return null;
    }

    public int getMin(){
        return 0;
    }

    public int getMax(){
        return 0;
    }

    public int getAverage(){
        return 0;
    }

    public String[][] sortCandidats(){
        return null;
    }

    public String[][] citiesVotes(){
        return null;
    }
}