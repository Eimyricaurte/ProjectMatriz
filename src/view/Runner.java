package view;


import logic.HandlingElection;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * The `Runner` class represents the main user interface for interacting with the system.
 */
public class Runner {
    Scanner sc = new Scanner(System.in);
    HandlingElection he = new HandlingElection();

    /**
     * The entry point of the application. Creates an instance of Runner and calls the menu method.
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {

        new Runner().menu();
    }

    /**
     * Displays the main menu and handles user input .
     */
    public void menu() {
        boolean sentinel = true ;
        while (sentinel){

            System.out.println("--------------------- Menu --------------------\n" +
                    "1. Number of votes per candidate\n" +
                    "2. Winner candidate\n" +
                    "3. Search for candidate\n" +
                    "4. List of candidates' votes\n" +
                    "5. Number of votes per municipality\n" +
                    "6. Go out");
            try {
                int option = sc.nextInt();
                switch (option) {
                    case 1:
                        System.out.println(he.elections());
                        break;
                    case 2:
                        System.out.println("The winner is: " + he.winnerCandidate());
                        break;
                    case 3:
                        findCandidate();
                        break;
                    case 4:
                        System.out.println(he.sortCandidates());
                        break;
                    case 5:
                        System.out.println(he.totalCitiesVotes());
                        break;
                    case 6:
                        sentinel = false;
                        break;
                    default:
                        System.err.println("invalid option");
                }
            }catch (Exception e){
                System.err.println("Invalid Option, enter again");
                sc.nextLine();
                menu();
            }
        }
    }

    /**
     * Method that displays the candidate menu and manages the candidate search with the user's input.
     */
    public void findCandidate(){
        int option1 = 0;
        do {
            System.out.println("************ Candidates *********** \n" +
                    "1. Carlos Santamaria \n" +
                    "2. Ana Maria Restrepo \n" +
                    "3. Alberto Rodriguez \n" +
                    "4. Rodrigo Fernandez \n" +
                    "5. Martha Solano \n");

            System.out.println("Enter the candidate you want to search for\n ");
            try {
                int option = sc.nextInt();

                switch (option) {
                    case 1:
                        System.out.println("Carlos Santamaria");
                        methods(option);
                        break;
                    case 2:
                        System.out.println("Ana Maria Restrepo");
                        methods(option);

                        break;
                    case 3:
                        System.out.println("Alberto Rodriguez");
                        methods(option);
                        break;
                    case 4:
                        System.out.println("Rodrigo Fernandez");
                        methods(option);
                        break;
                    case 5:
                        System.out.println("Martha Solano");
                        methods(option);
                        break;
                    default:
                        System.err.println("Invalid Option");
                }
                System.out.println("want to look for another candidate? Enter 1 yes, or 2 no");
                option1 = sc.nextInt();
            } catch (Exception e) {
                System.err.println("Invalid Option, enter again");
                sc.nextLine();
                findCandidate();
            }
        } while (option1 == 1);
    }

    /**
     * method that displays the required data for the candidate you have selected
     * @param option receives the option of the candidate for whom you wish to obtain data
     */
    public void methods(int option){
        System.out.println("The municipality in which it had the lowest number of votes is: " + he.getMin(option));
        System.out.println("The municipality in which it had the highest number of votes is: " + he.getMax(option));
        System.out.println("The average number of votes he had is: " + he.getAverage(option));
    }
}
