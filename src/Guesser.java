/*
    Document   : Guesser.java
    Created on : June 1, 2022 
    Author     : Cloyd Van S. Secuya
    Description:
        This is class file to implement a test algorithm to make a console based
        Guesser game.

        The objective is to allow the user to enter an input which should correspond 
        whether their input is matched with the random generated number or not. 

        We should implement an algorithm that should actively check whether the user 
        input is HIGHER or LOWER than/to the generated number.
            Futhermore, we must fix the user in a loop where they will keep guessing until
            they get the generated number right with their input
*/



// IMPORT SECTION 
import java.util.Random;
import java.util.Scanner;



public class Guesser {

    // Value limit to guess 
    int MAX_THRESHOLD = 100;

    // Values
    int no_of_guesses = 0; 

    // Random class for implementing rgn
    private Random random = new Random(); 
    private int rgn = random.nextInt(MAX_THRESHOLD); 
    
    // User input to guess
    int input;  


    // A method to set the RGN; not more than the MAX_THRESHOLD
    public void setRGN() {
        random = new Random(); 
        input = random.nextInt(MAX_THRESHOLD); 
    }

    // A method responsible for returning the value of the generated number 
    public int getRGN() {
        return rgn;
    }

    public static void main(String[] args) {
        Guesser guess = new Guesser(); 
        Scanner sc = new Scanner(System.in);
        
        while (guess.input != guess.rgn) { 
            // User prompt
            System.out.println("\n");
            System.out.print("Guess your answer: ");
            guess.input = sc.nextInt(); 

            // Calculate the number of guess
            guess.no_of_guesses = guess.no_of_guesses + 1;

            // Conditions to actively check the user input and compare it with
            // our rgn
            if (guess.input < guess.rgn) {
                System.out.println("HIGHER");
            }
                
            else if (guess.input > guess.rgn) {
                System.out.println("LOWER");
            }
        }

        System.out.println("YOU WON!");
        System.out.println("Number of guess: " + guess.no_of_guesses);
        
        // Close the Scanner to avoid memory leak!
        sc.close();
        
        // NOTE: THIS WHILE LOOP IS RESPONSIBLE FOR PRINTING AND TESTING THE 
        //       GENERATED RGNs. Uncomment to test! 
        // while(true) {
        //     guess.setRGN();
        //     System.out.println(guess.getRGN());
        // }
        
    }

}