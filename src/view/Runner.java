package view;

import logic.HandlingElection;

import java.util.Arrays;
import java.util.Scanner;

public class Runner {
    static Scanner sc = new Scanner(System.in);
    static HandlingElection he = new HandlingElection();

    public static void main(String[] args) {

        System.out.println(he.showVotes());
        System.out.println(he.showCans());
        System.out.println(he.showCities());
        Runner.menu();
    }

    private static void menu() {
        boolean centinel = true ;
        while (centinel){

            System.out.println("--------------------- Menu --------------------\n" +
                    "1. Winner candidate\n" +
                    "2. Number of votes per candidate\n" +
                    "3. Search for candidate\n" +
                    "4. List of candidates' votes\n" +
                    "5. Number of votes per municipality\n" +
                    "6. Go out");

                int option = sc.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("The winner is: " + he.winnerCandidate());
                        break;
                    case 2:
                        System.out.println(he.elections());
                        break;
                    case 3:
                        Runner.findCandidate();
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        centinel = false;
                    default:
                        System.err.println("invalid Option");
                }

        }
    }
    public void winnerCandidate(){

    }
    public void votesCandidates(){

    }
    public static void findCandidate(){
        System.out.println("Enter the candidate you want to search for\n "+
                "----------- Candates -----------" +
                "1. Carlos Santamaria \n" +
                "2. Ana Maria Restrepo \n" +
                "3. Alberto Rodriguez \n" +
                "4. Rodrigo Fernandez \n" +
                "5. Martha Solano \n");
        int option = sc.nextInt();
        switch (option){
            case 1:
                System.out.println("Carlos Santamaria");
                System.out.println("The municipality in which it had the lowest number of votes is: " + he.getMin(option));
                System.out.println("The municipality in which it had the highest number of votes is: " + he.getMax(option));
                System.out.println("The average number of votes he had is: " + he.getAverage(option));
                break;
            case 2:
                System.out.println("Ana Maria Restrepo");
                System.out.println("The municipality in which it had the lowest number of votes is: " + he.getMin(option));
                System.out.println("The municipality in which it had the highest number of votes is: " + he.getMax(option));
                System.out.println("The average number of votes he had is: " + he.getAverage(option));
                break;
            case 3:
                System.out.println("Alberto Rodriguez");
                System.out.println("The municipality in which it had the lowest number of votes is: " + he.getMin(option));
                System.out.println("The municipality in which it had the highest number of votes is: " + he.getMax(option));
                System.out.println("The average number of votes he had is: " + he.getAverage(option));
                break;
            case 4:
                System.out.println("Rodrigo Fernandez");
                System.out.println("The municipality in which it had the lowest number of votes is: " + he.getMin(option));
                System.out.println("The municipality in which it had the highest number of votes is: " + he.getMax(option));
                System.out.println("The average number of votes he had is: " + he.getAverage(option));
                break;
            case 5:
                System.out.println("Martha Solano");
                System.out.println("The municipality in which it had the lowest number of votes is: " + he.getMin(option));
                System.out.println("The municipality in which it had the highest number of votes is: " + he.getMax(option));
                System.out.println("The average number of votes he had is: " + he.getAverage(option));
            default:
        }

    }
    public void listCandidates (){

    }
    public void totalVotesCities(){

    }
}
