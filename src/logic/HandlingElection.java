package logic;

import java.util.Random;
import java.util.SplittableRandom;

public class HandlingElection {

    private String[] candidates;
    private String[] cities;
    private int[][] votes;

    public HandlingElection() {
        candidates = new String[5];
        cities = new String[3];
        votes = new int[candidates.length][cities.length];
        loadElements(50,100);
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
    public String showVotes(){
        StringBuilder sb = new StringBuilder();

        for( int i = 0 ; i < votes.length ; i++ ){
            for( int j = 0 ; j < votes[i].length ; j++ ){
                sb.append( votes[i][j] + "\t");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public String[][] matrixElections (String [] candidates, String [] cities, String [][] votes){
        String[][] matrix = new String[candidates.length + 2][cities.length + 1];
        for (int i = 0 ; i < matrix.length ; i++ ){
            for (int j = 0; j < matrix[i].length ; j++){

            }
        }

        return null;
    }

    public String winnerCandidate(){

        return null;
    }

    public String[] elections(){
        return null;
    }

    public int sumVotes(){
        return 0;
    }

    public String[] findCandidate(String candidate){
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

    public String[][] sortCandidates(){
        return null;
    }

    public String[][] totalCitiesVotes(){
        return null;
    }
}