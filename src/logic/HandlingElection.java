package logic;

import java.util.Arrays;
import java.util.Random;
import java.util.SplittableRandom;

public class HandlingElection {

    private String[] candidates = {"Carlos Santamaria", "Ana Maria Restrepo", "Alberto Rodriguez", "Rodrigo Fernandez", "Martha Solano"};
    private String[] cities = {"Tunja", "Sogamoso", "Duitama"};
    private int[][] votes;

    public HandlingElection() {
        votes = new int[candidates.length][cities.length];
        loadElements(50, 100);
    }

    private void loadElements(int begin, int end) {

        int min = begin <= end ? begin : end;
        int max = begin >= end ? begin : end;
        for (int i = 0; i < votes.length; i++) {
            for (int j = 0; j < votes[i].length; j++) {
                votes[i][j] = new Random().nextInt(max - min + 1) + min;
            }
        }
    }

    public String showVotes() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < votes.length; i++) {
            for (int j = 0; j < votes[i].length; j++) {
                sb.append(votes[i][j] + "\t");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public String showCans() {
        StringBuffer sb = new StringBuffer("[");
        for (int i = 0; i < candidates.length; i++) {
            sb.append(candidates[i] + ",");
        }
        String aux = sb.substring(0, sb.length() - 1);
        aux += "]";
        return aux.toString();
    }

    public String showCities() {
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

    public String winnerCandidate() {
        int tVotes;
        int maxVotes = 0;
        String winner = "";
        for (int i = 0; i < candidates.length; i++) {
            tVotes = 0;
            for (int j = 0; j < cities.length; j++) {
                tVotes += votes[i][j];
            }
            if (tVotes > maxVotes) {
                maxVotes = tVotes;
                winner = candidates[i];
            }
        }
        return winner;
    }

    public String elections() {

        int rows = candidates.length + 1;
        int cols = cities.length + 2;

        String[][] results = new String[rows][cols];
        results[0][0] = String.format("%-20s","Candidates");
        results[0][4] = String.format("%-6s","Total");

        for (int i = 0; i < candidates.length; i++) {
            results[i + 1][0] = String.format("%-20s",candidates[i]);
        }

        for (int j = 0; j < cities.length; j++) {
            results[0][j + 1] = String.format("%-10s",cities[j]);
        }

        for (int i = 0; i < candidates.length; i++) {
            int total = 0;
            for (int j = 0; j < cities.length; j++) {
                results[i + 1][j + 1] = String.format("%-10s",votes[i][j]);
                total += votes[i][j];
            }
            results[i + 1][cols - 1] = String.format("%-6s",total);
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < results.length; i++) {
            for (int j = 0; j < results[i].length; j++) {
                sb.append(results[i][j] + "| \t");
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

    public String sortCandidates() {

        String [][] totalVC = new String[candidates.length + 1][2];
        int[] totalArray = new int[candidates.length];

        totalVC[0][0] = String.format("%-20s","Candidate");
        totalVC[0][1]= String.format("%-12s","Total Votes");

        for (int i = 0; i < candidates.length; i++) {
            totalVC[i + 1][0] = String.format("%-20s",candidates[i]);
        }

        for (int i = 0; i < candidates.length; i++) {
            int total = 0;
            for (int j = 0; j < cities.length; j++) {
                totalVC[i + 1][1] = Integer.toString(votes[i][j]);
                total += votes[i][j];
            }
            totalArray[i] = total;
            totalVC[i + 1][1] = String.format("%-12s",(total));
        }

        for (int pivot = totalArray.length; pivot > 1; pivot--) {
            for (int index = 0; index < pivot - 1; index++) {
                if (totalArray[index] < totalArray[index + 1]) {
                    // Swap candidates and their total votes
                    int auxTotal = totalArray[index + 1];
                    totalArray[index + 1] = totalArray[index];
                    totalArray[index] = auxTotal;

                    String[] auxCandidate = totalVC[index + 1];
                    totalVC[index + 1] = totalVC[index + 2];
                    totalVC[index + 2] = auxCandidate;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < totalVC.length; i++) {
            for (int j = 0; j < totalVC[i].length; j++) {
                sb.append(totalVC[i][j] + " | \t");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public String totalCitiesVotes() {
        String[][] citiesTotal = new String[2][cities.length+1];

        citiesTotal[0][0] = String.format("%-12s","City");
        citiesTotal[1][0] = String.format("%-12s","Total Votes");
        for (int i = 0; i < cities.length; i++) {
            citiesTotal[0][i + 1] = String.format("%-8s",cities[i]);
        }

        for (int j = 0; j < cities.length; j++) {
            int totalVotes = 0;
            for (int i = 0; i < candidates.length; i++) {
                totalVotes += votes[i][j];
            }
            citiesTotal[1][j + 1] = String.format("%-8s",(totalVotes));
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < citiesTotal.length; i++) {
            for (int j = 0; j < citiesTotal[i].length; j++) {
                sb.append(citiesTotal[i][j] + " | \t");
            }
            sb.append("\n");
        }

        return sb.toString();

    }
}
