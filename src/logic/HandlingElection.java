package logic;

import java.util.Random;
import java.util.SplittableRandom;

public class HandlingElection {

    private String[] candidates = {"Carlos Santamaria", "Ana Maria Restrepo", "Alberto Rodriguez", "Rodrigo Fernandez", "Martha Solano"};
    private String[] cities = {"city1", "city2","city3"};
    private int[][] votes;

    public HandlingElection() {
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

    public String showCans(){
        StringBuffer sb = new StringBuffer("[");
        for (int i = 0; i < candidates.length; i++) {
            sb.append(candidates[i] + ",");
        }
        String aux = sb.substring(0, sb.length() - 1);
        aux += "]";
        return aux.toString();
    }

    public String showCities(){
        StringBuffer sb = new StringBuffer("[");
        for (int i = 0; i < cities.length; i++) {
            sb.append(cities[i] + ",");
        }
        String aux = sb.substring(0, sb.length() - 1);
        aux += "]";
        return aux.toString();
    }

    /*public String[][] matrixElections (String [] candidates, String [] cities, String [][] votes){
        String[][] matrix = new String[candidates.length + 2][cities.length + 1];
        for (int i = 0 ; i < matrix.length ; i++ ){
            for (int j = 0; j < matrix[i].length ; j++){

            }
        }

        return null;
    }*/

    public String winnerCandidate(){

        int tVotes;
        int maxVotes = 0;
        String winner = "";
        for (int i = 0; i < candidates.length; i++){
            tVotes = 0;
            for (int j = 0; j < cities.length; j++){
                tVotes += votes[i][j];
            }
            if (tVotes > maxVotes){
                maxVotes= tVotes;
                winner = candidates[i];
            }
        }
        return winner;
    }

    public String elections(){

        int rows = candidates.length +1;
        int cols = cities.length + 2;

        String[][] results = new String[rows][cols];
        for (int i = 0; i < candidates.length; i++){
            results[i + 1][0] = candidates[i];
        }

        for (int j = 0; j < cities.length; j++){
            results[0][j + 1] =  cities[j];
        }

        for (int i = 0; i< candidates.length; i++){
            int total = 0;
            for (int j = 0; j < cities.length; j++){
                results[i + 1][j + 1] = Integer.toString(votes[i][j]);
                total += votes[i][j];
            }
            results[i + 1][cols - 1] = Integer.toString(total);
        }
        StringBuilder sb = new StringBuilder();

        for( int i = 0 ; i < results.length ; i++ ){
            for( int j = 0 ; j < results[i].length ; j++ ){
                sb.append( results[i][j] + "\t");
            }
            sb.append("\n");
        }

        return sb.toString();
    }


    public String  getMin( int can){

        int p  = can -1;
        int min= 999;
        String minCity  = "";
        for (int j = 0; j < cities.length; j++){
            int vote = votes[p][j];
            if (vote < min){
                min = vote;
                minCity =  cities[j];
            }
        }

        return minCity;

    }

    public String getMax(int can){
        int p  = can -1;
        int max= 0;
        String maxCity  = "";
        for (int j = 0; j < cities.length; j++){
            int vote = votes[p][j];
            if (vote > max){
                max = vote;
                maxCity =  cities[j];
            }
        }

        return maxCity;
    }

    public double getAverage( int can){
        int p = can - 1;
        int sum = 0;
        for (int i = 0; i < cities.length; i++){
            sum += votes[p][i];
        }

        return sum/3;
    }

    public String[][] sortCandidates(){
        return null;
    }

    public String[][] totalCitiesVotes(){

        String [][] citiesTotal = new String[2][cities.length];

        return null;
    }
}