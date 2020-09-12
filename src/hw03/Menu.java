package hw03;

import java.util.Scanner;

public class Menu {
    //  TODO: Data fields to pass from NpcMain for the menu class
    Npc[] arrNpc;   //  Array of objects
    Npc whichNpc;   //  Check which NPC object user chose for

    int firstChoiceNum = 0; //  Stores the first choiceNumber for the class
    int firstLength = 0;    //  Store the length of the menu items in the first menu
    boolean exitProgram;    //  Exit the program boolean


    public Menu(Npc[] arrNpc) {
        this.arrNpc = arrNpc;
    }



    /*  TODO: Create methods for the menu class*/

    //  Method to check validation and run the menu
    public void runMenu() {
        while(!exitProgram) {
            printMenu();
        }
    }

    //  Method to print out the menu
    public void printMenu() {
        Npc[] arrNpc = this.arrNpc; //  Create a local arrNpc to catch reference of this.arrNpc
        int choiceLength = this.arrNpc.length + 1;   //  The length of the choices, add one because arrays
        int choiceNum;  //  The choiceNum of the user to be passed later
        int exitNum;    //  Exit application number for user to enter
        Scanner userInput = new Scanner(System.in); //  Scanner to be used later


        System.out.println("Choose an NPC");

        //  Print out the string name, and increment the choiceLength
        for (int i = 0; i < arrNpc.length; i++) {
            String eachNpc = (i + 1) + ". " +  arrNpc[i].getName();
            System.out.println(eachNpc);
        }

        //  Output the exit and choice to the user, dynamically
        System.out.println(choiceLength + ". Exit Program");
        System.out.print("Enter the number choice (1-" + choiceLength + "): ");

        //  Make the length of the menu items accessible to the class
        this.firstLength = choiceLength;

        choiceNum = userInput.nextInt();    //  Ask the user for their number
        validateUserInput(choiceNum);  //  Validate user input
    }

    //  Method to validateUserInput for the first choice number
    public void validateUserInput(int choiceNum) {
        //  set the inBounds to false
        boolean inBounds = false;
        int validatedChoiceNum;

        //  While the choiceNum is less than 0 or greater than the list
        while(!inBounds) {
            if(choiceNum > 0 || choiceNum <= firstLength) {
                validatedChoiceNum = choiceNum;
                inBounds = true;
                printSubMenu(validatedChoiceNum);
            } else {
                System.out.println("Please try again\n");
            }
        }
    }

    public void printSubMenu(int choiceNum) {
        boolean exitSubMenu = false;
        Scanner secondUserInput = new Scanner(System.in);

        if (choiceNum == firstLength) {
            this.exitProgram = true;
            System.out.println("Exited program successfully, thank you for using this application.");
        } else {
            while (!exitSubMenu) {
                this.whichNpc = arrNpc[choiceNum - 1];
                System.out.println("Test Menu for " + whichNpc.getName());

                System.out.println("1. Display NPC Information.");
                System.out.println("2. Talk to NPC.");
                System.out.println("3. Make NPC Walk up.");
                System.out.println("4. Make NPC Walk down.");
                System.out.println("5. Make NPC Walk left.");
                System.out.println("6. Make NPC Walk right.");
                System.out.println("7. Go back to the previous menu.");

                System.out.print ("Enter the number choice (1-7): ");

                //  Ask the user to input a new number choice
                int secondChoiceNum = secondUserInput.nextInt();

                //  If the second choice is greater than 0 and less than or equal to 7, peform an action
                if(secondChoiceNum > 0 && secondChoiceNum <= 6) {
                    performAction(secondChoiceNum);
                } else if(secondChoiceNum == 7) {
                    exitSubMenu = true;
                    runMenu();
                }
            }
        }
    }

    public void performAction(int secondChoiceNum) {
        switch (secondChoiceNum) {
            case 1:
                System.out.println(this.whichNpc.toString());
                break;
            case 2:
                whichNpc.talk();
                break;
            case 3:
                whichNpc.walk("up");
                break;
            case 4:
                whichNpc.walk("down");
                break;
            case 5:
                whichNpc.walk("left");
                break;
            case 6:
                whichNpc.walk("right");
                break;
            default:
                System.out.println("An unknown error has occurred, you are screwed.");
                break;
        }
    }
}
