// --== CS400 File Header Information ==--
// Name: Allen Soley
// Email: asoley@wisc.edu
// Team: AC
// TA: Sophie
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>
import java.util.Scanner;
import java.util.NoSuchElementException;

/**
 * This is the front end development for the Badger Directory system.
 * 
 * @author Allen Soley
 *
 */
public class HashFrontEnd {

    /**
     * Because this is the user interface, all code will take place in the main() method
     * 
     * @param args
     */
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        DatabaseGenerator<String, Course> currGen = new DatabaseGenerator<>();

        System.out.println("Welcome to the Badger Directory system!");
        String userInput = "";
        String courseID = "";
        

        while (!userInput.equalsIgnoreCase("q")) { // continues until the user enters "q"

            System.out.println();
            System.out.println("Please choose between the following choices! ");
            System.out.println("G - Get a course from the current directory system. ");
            System.out.println("R - Remove a course from the current directory system. ");
            System.out.println("C - Clear all current courses from the current directory system. ");
            System.out.println("Q - Quit the program. ");
            System.out.println();

            userInput = scnr.next().toLowerCase();

            switch (userInput) {     

                case "g":
                    System.out.println("Please enter the course ID. (ex cs400) ");
                    courseID = scnr.next().toUpperCase();

                    try {
                        System.out.println(currGen.database.get(courseID));
                    }

                    catch (NoSuchElementException e) {
                        System.out.println(
                            "Sorry, that course isn't in the Directory! Please try again. ");
                    }
                    break;

                case "r":
                    System.out.println("Please enter the course ID you want removed. (ex cs400) ");
                    courseID = scnr.next().toUpperCase();

                    try {
                        if (currGen.database.remove(courseID) != null) {
                            System.out.println(courseID + " was removed.");
                        }
                    } catch (Exception e) {
                        System.out.println("Sorry, we can't remove something that isn't there! ");
                    }

                    break;

                case "c":
                    currGen.database.clear();
                    System.out.println("The Badger Directory has been cleared. ");
                    break;

                
                case "q":
                    System.out.println("Bye! See you again! ");
                    break;

                default:
                    System.out.println("Unrecognized entry, please check your input. ");
            }


        }


    }

}
