package logic;

import java.util.Arrays;
import java.util.Random;
import java.util.SplittableRandom;

/**
 * class that manages the data of an election process
 */
public class HandlingElection {

    private String[] candidates = {"Carlos Santamaria", "Ana Maria Restrepo", "Alberto Rodriguez", "Rodrigo Fernandez", "Martha Solano"};
    private String[] cities = {"Tunja", "Sogamoso", "Duitama"};
    private int[][] votes;

    /**
     * Method that establishes the voting matrix
     */
    public HandlingElection() {
        votes = new int[candidates.length][cities.length];
        loadElements(50, 100);
    }

    /**
     * Method for loading the elements of the voting matrix
     * @param begin receives from where the range of the array goes
     * @param end receives up to the range of the array
     */
    private void loadElements(int begin, int end) {

        int min = begin <= end ? begin : end;
        int max = begin >= end ? begin : end;
        for (int i = 0; i < votes.length; i++) {
            for (int j = 0; j < votes[i].length; j++) {
                votes[i][j] = new Random().nextInt(max - min + 1) + min;
            }
        }
    }

    /**
     * Method to visualize the winning candidate
     * @return the name of the winning candidate
     */
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

    /**
     * Method that generates the matrix of candidates and cities with their respective votes and the total votes
     * obtained by each candidate.
     * @return the matrix table obtained.
     */
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

    /**
     * Method showing the city in which the candidate received the least votes.
     * @param can receives the option number of the candidate to be searched for.
     * @return the city in which the candidate sought received the fewest votes.
     */
    public String getMin( int can){
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

    /**
     * Method that shows the city in which the candidate received the most votes.
     * @param can receives the option number of the candidate to be searched for.
     * @return the city in which the sought-after candidate received the most votes.
     */
    public String getMax(int can){
        int p  = can -1;
        int max= 0;
        String maxCity = "";
        for (int j = 0; j < cities.length; j++){
            int vote = votes[p][j];
            if (vote > max){
                max = vote;
                maxCity =  cities[j];
            }
        }

        return maxCity;
    }

    /**
     * Method that shows the average number of votes obtained by the candidate.
     * @param can receives the option number of the candidate to be searched for.
     * @return the average number of votes obtained by the candidate.
     */
    public double getAverage( int can){
        int p = can - 1;
        int sum = 0;
        for (int i = 0; i < cities.length; i++){
            sum += votes[p][i];
        }

        return sum/3;
    }

    /**
     * Method that orders from highest to lowest number of votes obtained by each candidate.
     * @return table with the name of each candidate and the total number of votes obtained by each one from highest to lowest.
     */
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

    /**
     * Method showing the number of votes obtained in each city.
     * @return table with the name of each city and total number of votes obtained.
     */
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