package hw03;

import java.util.Scanner;

public class Npc {
    /*  TODO: Create the data fields for the Npc    */

    private String name, race;
    private int xPos, yPos;
    private String[] dialogue;  //  Array of string to hold random or sequential dialogue
    private boolean hasSequentialDialogue;  //  Boolean to check if dialogue is random or sequential
    private int nextDialogue;   //  Int index to track which index you are in the dialogue array


    /*  TODO: Create the default and inputted constructor for Npc   */
    public Npc() {
        this.name = "UNNAMED";
        this.race = "NO RACE";
        this.xPos = -999;
        this.yPos = -999;
        this.dialogue = new String[] {"PLACEHOLDER TEXT"};
        this.hasSequentialDialogue = false;
        this.nextDialogue = 0;
    }

    public Npc(String name, String race, int xPos, int yPos, String[] dialogue, boolean hasSequentialDialogue) {
        setName(name);
        setRace(race);
        setxPos(xPos);
        setyPos(yPos);
        setDialogue(dialogue);
        setHasSequentialDialogue(hasSequentialDialogue);
        this.nextDialogue = 0;
    }


    /*  TODO: Create getters and setters for the Npc class  */

    //  Getter and setter for the 'name' data field
    public String getName() { return this.name; }
    public void setName(String name) {
        if (name == "") {
            System.out.println("Error. This name is nil.");
        } else {
            this.name = name;
        }
    }

    //  Getter and setter for the 'race' data field
    public String getRace() { return this.race; }
    public void setRace(String race) {
        if (race == "") {
            System.out.println("Error. This race is nil");
        } else {
            this.race = race;
        }
    }

    //  Getter and setter for 'xPos' data field
    public int getxPos() { return this.xPos; }
    public void setxPos(int xPos) {
        if(xPos < 0) {
            System.out.println("Error. Please set the xPos greater than or equal to 0");
        } else {
            this.xPos = xPos;
        }
    }

    //  Getter and setter for the 'yPos' data field
    public int getyPos() { return this.yPos; }
    public void setyPos(int yPos) {
        if(yPos < 0) {
            System.out.println("Error. Please set the yPos greater than or equal to 0.");
        } else {
            this.yPos = yPos;
        }
    }

    //  Getter and setter for 'dialogue' array
    public String[] getDialogue() { return this.dialogue; }
    public void setDialogue(String[] dialogue) {
        this.dialogue = dialogue;
        this.nextDialogue = 0;  //  The index should be now 0 as new dialogue array is set
    }


    //  Getter and setter for the 'hasSequentialDialogue' data field
    public boolean getHasSequentialDialogue() { return this.hasSequentialDialogue; }
    public void setHasSequentialDialogue(boolean hasSequentialDialogue) {
        this.hasSequentialDialogue = hasSequentialDialogue;
    }



    /*  TODO: Create the methods for the Npc class below*/

    //  talk() method prints out dialogue, whether is sequential or random
    public void talk() {
        int dialogueLength = this.dialogue.length;
        int nextDialogue = this.nextDialogue;
        boolean hasSequentialDialogue = this.hasSequentialDialogue;

        //  If the dialogue has sequential data, print out in sequential order
        if (hasSequentialDialogue)  {
            for (int i = 0; i < dialogueLength; i++) {
                System.out.println(dialogue[nextDialogue]);
                nextDialogue++;

                //  If the nextDialogue index equals to the length, set it again to 0
                if (nextDialogue == dialogueLength) {
                    nextDialogue = 0;
                }
            }
        } else {
            //  Else if it's random, print at random
            for (int i = 0; i < dialogueLength; i++) {
                int randomInt = getRandomIntBetweenRange(nextDialogue, dialogueLength - 1);
                System.out.println(dialogue[randomInt]);
            }
        }
    }


    //  Walk method to increment or decrement the position of "up", "down", "left", "right"
    public void walk(String directionStr) {
        //  Change increment or decrement according to the direction.
        switch (directionStr) {
            case "up":
                //  If the yPos is less than or equal to 0 then set it equal to 0 again, else add one
                this.yPos = this.yPos <= 0 ? 0 : this.yPos + 1;
                break;
            case "down":
                //  If the yPos is less than or equal to 0 then set it equal to 0 again, else decrement one
                this.yPos = this.yPos <= 0 ? 0 : this.yPos - 1;
                break;
            case "left":
                //  If the xPos is less than or equal to 0 then set it equal to 0 again, else decrement one
                this.xPos = this.xPos <= 0 ? 0 : this.xPos - 1;
                break;
            case "right":
                //  If the xPos is less than or equal to 0 then set it equal to 0 again, else add one
                this.xPos = this.xPos <= 0 ? 0 : this.xPos + 1;
                break;
            default:
                System.out.println("An unknown error occurred in the walk() method");
                break;
        }
    }

    //  Method for creating a string representation for the class
    @Override
    public String toString() {
        String classStringOne = "Name: " + this.name + "\n" + "Race: " + this.race + "\n" ;
        String classStringTwo = "Location: (" + this.xPos + ", " + this.yPos + ")\n";
        String classStringThree = "Sequential: " + this.hasSequentialDialogue + "\n" + "Dialogue: " + reformatString(this.dialogue);

        return classStringOne + classStringTwo + classStringThree;
    }

    public String reformatString(String[] strArr) {
        //  Create a new string builder instance
        StringBuilder builder = new StringBuilder();

        //  Each time the string array is looped, append it to the builder instance
        for (int i = 0; i < strArr.length; i++) {
            builder.append(strArr[i] + "\n\t\t" + "  ");
        }

        //  Now format the string using the .toString() method
        String formattedString = builder.toString();

        //  Return teh string
        return formattedString;
    }


    public static int getRandomIntBetweenRange(int min, int max){
        int x = (int) ((Math.random() * ( (max - min ) + 1 ) ) + min);
        return x;
    }
}
