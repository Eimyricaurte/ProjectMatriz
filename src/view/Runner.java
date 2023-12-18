package view;


import logic.HandlingElection;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Runner {
    static Scanner sc = new Scanner(System.in);
    static HandlingElection he = new HandlingElection();

    static Runner runner = new Runner();
    public static void main(String[] args) {

        System.out.println(he.showCans());
        System.out.println(he.showCities());
        System.out.println(he.showVotes());
        Runner.menu();
    }

    private static void menu() {
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
                        Runner.findCandidate();
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

    public static void findCandidate(){
        int option1 = 0;
        do {
            System.out.println("----------- Candidates ----------- \n" +
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
                        runner.methods(option);
                        break;
                    case 2:
                        System.out.println("Ana Maria Restrepo");
                        runner.methods(option);

                        break;
                    case 3:
                        System.out.println("Alberto Rodriguez");
                        runner.methods(option);
                        break;
                    case 4:
                        System.out.println("Rodrigo Fernandez");
                        runner.methods(option);
                        break;
                    case 5:
                        System.out.println("Martha Solano");
                        runner.methods(option);
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
    public void methods(int option){
        System.out.println("The municipality in which it had the lowest number of votes is: " + he.getMin(option));
        System.out.println("The municipality in which it had the highest number of votes is: " + he.getMax(option));
        System.out.println("The average number of votes he had is: " + he.getAverage(option));
    }
}
