import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
public class Snake1 {
public static void main(String[] args) throws IOException {
Scanner sc =new Scanner(System.in);
System.out.println("Welcome To Snakes And Ladders");
System.out.println("Instructions:");
System.out.println("This program will simulate a regular snakes and ladders game");
System.out.println("You and the computer will start from square number 1");
System.out.println("If the computer or user will land on top of a snake you go down a few squares");
System.out.println("If the computer or user will land at bottom of a ladder you go up a few squares");
System.out.println("Whoever reaches at square number 100 first will Win the game");




//  Snake and Ladder Board
snakegame s1 =new snakegame(1,1,0,1,1,"y");
String sGame = "y";     
System.out.print ("Do you want to play the game? Y or N     >  "); // ask user if we wants to play the game again
sGame = sc.nextLine();
System.out.print ("\n\n\n\n\n\n");
while (sGame.equals ("y") || sGame.equals ("Y"))
{
    sGame = s1.startGame("y");
}

    System.out.println("BYE BYE!!!!");
}
}

class snakegame{

private int userPosition ;
private int compPosition ;
private int diceRoll ;
private int userRoll ;
private int compRoll ;
private String playAgain ;

snakegame(int userPosition,int compPosition,int diceRoll,int userRoll,int compRoll,String playAgain)
{
this.userPosition =userPosition;
this.compPosition=compPosition ;
this.diceRoll=diceRoll ;
this.userRoll=userRoll ;
this.compRoll=compRoll ;
this.playAgain=playAgain ;

}


public String startGame(String start) throws IOException
{           // start startGame method
         Scanner sc =new Scanner(System.in);
        int[] snakesLaddersArray  = new int [20]; // create a 6 element array
        // store the snakes and ladders location in the array
        snakesLaddersArray[0] = 27;
        snakesLaddersArray[1] = 40;
        snakesLaddersArray[2] = 43;
        snakesLaddersArray[3] = 56;
        snakesLaddersArray[4] = 67;
        snakesLaddersArray[5] = 72;
        snakesLaddersArray[6] = 93;
        snakesLaddersArray[7] = 95;
        snakesLaddersArray[8] = 97;
        snakesLaddersArray[9] = 99;
        snakesLaddersArray[10] = 4;
        snakesLaddersArray[11] = 6;
        snakesLaddersArray[12] = 8;
        snakesLaddersArray[13] = 10;
        snakesLaddersArray[14] = 41;
        snakesLaddersArray[15] = 58;
        snakesLaddersArray[16] = 61;
        snakesLaddersArray[17] = 65;
        snakesLaddersArray[18] = 74;
        snakesLaddersArray[19] = 89;


        while (playAgain.equals ("y") || playAgain.equals ("Y")) {
            userRoll =  getDice(diceRoll);
            compRoll =  getDice(diceRoll);
            System.out.println ("You  have Rolled a " + userRoll); 
            System.out.println ("The Computer has Rolled a " + compRoll); 
            System.out.println ("------------------------------------------");
            
            userPosition = userPosition + userRoll;
            
            compPosition = compPosition + compRoll;
          
            userPosition = getP(userPosition, userRoll, snakesLaddersArray);
            
            compPosition = compgetP(compPosition, compRoll, snakesLaddersArray, userPosition);

            System.out.println("You are currently on square number:" + userPosition + "*"); // print out the user's current location
            System.out.println("The Computer is currently on square number:" + compPosition + "*"); // print out the computer's current location
            
            // resets the position values, if the user or the computer won
            // so that the user could play the entire game again if he/she wanted to
            if (userPosition == 100 || compPosition == 100)
            {
                userPosition = 1;
                compPosition = 1;
                // asks the user if we wants to play again
                System.out.print ("Do you want to play the Game Again Y or N");
                playAgain = sc.nextLine();
                System.out.print ("\n\n\n\n\n\n\n\n\n\n\n\n");
            }
            else
            {
                // asks the user if we wants to continue playing
                System.out.print ("Continue to play the game? Y or N >  ");
                playAgain = sc.nextLine();
             }          
        }
        // end playAgain While
        return playAgain;           // returns prameter "playAgain" to main: if the user wants to play the game again
    }

    public static int getP (int userPosition, int userRoll, int snakesLaddersArray[]) throws IOException               // recieves two parameter from startGame
    {// start getP
       if(userPosition == snakesLaddersArray[0]) //if position equals snake 1
        {
            userPosition = 7; // set new position
            System.out.println ("You Got Bit By A Snake, GO DOWN!!!");
        }
        else if (userPosition == snakesLaddersArray[1]) //if position equals snake 2
        {
            userPosition = 20; // set new position
            System.out.println ("You Got Bit By A Snake, GO DOWN!!!");
        }
        else if (userPosition == snakesLaddersArray[2]) //if position equals snake 3
        {
            userPosition = 3; // set new position
            System.out.println ("You Got Bit By A Snake, GO DOWN!!!");
        }
        else if (userPosition == snakesLaddersArray[3]) //if position equals ladder 1
        {
            userPosition = 16; // set new position
            System.out.println ("You Got Bit By A Snake, GO DOWN!!!");
            
        }
        else if (userPosition == snakesLaddersArray[4]) //if position equals ladder 2
        {
            userPosition = 34; // set new position
            System.out.println ("You Got Bit By A Snake, GO DOWN!!!");
            
        }
        else if (userPosition == snakesLaddersArray[5]) //if position equals ladder 3
        {
            userPosition = 12; // set new position
            System.out.println ("You Got Bit By A Snake, GO DOWN!!!");
        }
        
        else if (userPosition == snakesLaddersArray[6]) //if position equals ladder 3
        {
            userPosition = 73; // set new position
            System.out.println ("You Got Bit By A Snake, GO DOWN!!!");
        }

        else if (userPosition == snakesLaddersArray[7]) //if position equals ladder 3
        {
            userPosition = 66; // set new position
            System.out.println ("You Got Bit By A Snake, GO DOWN!!!");
        }

        else if (userPosition == snakesLaddersArray[8]) //if position equals ladder 3
        {
            userPosition = 44; // set new position
            System.out.println ("You Got Bit By A Snake, GO DOWN!!!");
        }

        else if (userPosition == snakesLaddersArray[9]) //if position equals ladder 3
        {
            userPosition = 19; // set new position
            System.out.println ("You Got Bit By A Snake, GO DOWN!!!");
        }
        else if (userPosition == snakesLaddersArray[10]) //if position equals ladder 3
        {
            userPosition = 37;                          // set new position
            System.out.println ("You Got A Ladder, GO UP!!!");
        }

        else if (userPosition == snakesLaddersArray[11]) //if position equals ladder 3
        {
            userPosition = 55; // set new position
            System.out.println ("You Got A Ladder, GO UP!!!");
        }

        else if (userPosition == snakesLaddersArray[12]) //if position equals ladder 3
        {
            userPosition = 68; // set new position
            System.out.println ("You Got A Ladder, GO UP!!!");
        }

        else if (userPosition == snakesLaddersArray[13]) //if position equals ladder 3
        {
            userPosition = 90; // set new position
            System.out.println ("You Got A Ladder, GO UP!!!");
        }

        else if (userPosition == snakesLaddersArray[14]) //if position equals ladder 3
        {
            userPosition = 60; // set new position
            System.out.println ("You Got A Ladder, GO UP!!!");
        }

        else if (userPosition == snakesLaddersArray[15]) //if position equals ladder 3
        {
            userPosition = 98; // set new position
            System.out.println ("You Got A Ladder, GO UP!!!");
        }

        else if (userPosition == snakesLaddersArray[16]) //if position equals ladder 3
        {
            userPosition = 81; // set new position
            System.out.println ("You Got A Ladder, GO UP!!!");
        }

        else if (userPosition == snakesLaddersArray[17]) //if position equals ladder 3
        {
            userPosition = 96; // set new position
            System.out.println ("You Got A Ladder, GO UP!!!");
        }

        else if (userPosition == snakesLaddersArray[18]) //if position equals ladder 3
        {
            userPosition = 94; // set new position
            System.out.println ("You Got A Ladder, GO UP!!!");
        }

        else if (userPosition == snakesLaddersArray[19]) //if position equals ladder 3
        {
            userPosition = 92; // set new position
            System.out.println ("You Got A Ladder, GO UP!!!");
        }

        if (userPosition < 0 || userPosition > 112)     // This is ab ERROR TRAP to catch any unwanted system errors that may occur by chance
        {
            System.out.println ("An error has occured please reset the game!!!!!!");
        }
        
        else if (userPosition > 100) // checks if user's location if greater then a 100
        {
            userPosition = userPosition - userRoll; // subtract userRoll from the userposition to get back old position
            System.out.println ("OHHH You cant jump, you must land on a 100"); // print out the users current location
            
        }
        else if (userPosition == 100)
        {
            System.out.println ("YOU WON, GOOD JOB!!!"); // print out that the user won
        }      
        return userPosition; 
                // return the final position to starGame: this position had gone through all checks and test and can be displayed on screen
    }
                // end getP


    public static int compgetP(int compPosition, int compRoll, int snakesLaddersArray [], int userPosition) throws IOException // recieves two parameter from startGame
    {// start getP
        if(compPosition == snakesLaddersArray[0]) //if position equals snake 1
        {
            compPosition = 7;       // set new position
            System.out.println ("Computer Got Bit By A Snake, GO DOWN!!!");
        }
        else if (compPosition == snakesLaddersArray[1]) //if position equals snake 2
        {
            compPosition = 20; // set new position
            System.out.println ("Computer Got Bit By A Snake, GO DOWN!!!");
            
        }
        else if (compPosition == snakesLaddersArray[2]) //if position equals snake 3
        {
            compPosition = 3; // set new position
            System.out.println ("Computer Got Bit By A Snake, GO DOWN!!!");
        }
        else if (compPosition == snakesLaddersArray[3]) //if position equals ladder 1
        {
            compPosition = 16; // set new position
            System.out.println ("Computer Got Bit By A Snake, GO DOWN!!!");
            
        }
        else if (compPosition == snakesLaddersArray[4]) //if position equals ladder 2
        {
            compPosition = 34; // set new position
            System.out.println ("Computer Got Bit By A Snake, GO DOWN!!!");
            
        }
        else if (compPosition == snakesLaddersArray[5]) //if position equals ladder 3
        {
            compPosition = 12; // set new position
            System.out.println ("Computer Got Bit By A Snake, GO DOWN!!!");
        }
        
        else if (compPosition == snakesLaddersArray[6]) //if position equals ladder 3
        {
            compPosition = 73; // set new position
            System.out.println ("Computer Got Bit By A Snake, GO DOWN!!!");
        }

        else if (compPosition == snakesLaddersArray[7]) //if position equals ladder 3
        {
            compPosition = 66; // set new position
            System.out.println ("Computer Got Bit By A Snake, GO DOWN!!!");
        }

        else if (compPosition == snakesLaddersArray[8]) //if position equals ladder 3
        {
            compPosition = 44; // set new position
            System.out.println ("Computer Got Bit By A Snake, GO DOWN!!!");
        }

        else if (compPosition == snakesLaddersArray[9]) //if position equals ladder 3
        {
            compPosition = 19; // set new position
            System.out.println ("Computer Got Bit By A Snake, GO DOWN!!!");
        }
        //
        else if (compPosition == snakesLaddersArray[10]) //if position equals ladder 3
        {
            compPosition = 37;                          // set new position
            System.out.println ("Computer Got A Ladder, GO UP!!!");
        }

        else if (compPosition == snakesLaddersArray[11]) //if position equals ladder 3
        {
            compPosition = 55; // set new position
            System.out.println ("Computer Got A Ladder, GO UP!!!");
        }

        else if (compPosition == snakesLaddersArray[12]) //if position equals ladder 3
        {
            compPosition = 68; // set new position
            System.out.println ("Computer Got A Ladder, GO UP!!!");
        }

        else if (compPosition == snakesLaddersArray[13]) //if position equals ladder 3
        {
            compPosition = 90; // set new position
            System.out.println ("Computer Got A Ladder, GO UP!!!");
        }

        else if (compPosition == snakesLaddersArray[14]) //if position equals ladder 3
        {
            compPosition = 60; // set new position
            System.out.println ("Computer Got A Ladder, GO UP!!!");
        }

        else if (compPosition == snakesLaddersArray[15]) //if position equals ladder 3
        {
            compPosition = 98; // set new position
            System.out.println ("Computer Got A Ladder, GO UP!!!");
        }

        else if (compPosition == snakesLaddersArray[16]) //if position equals ladder 3
        {
            compPosition = 81; // set new position
            System.out.println ("Computer Got A Ladder, GO UP!!!");
        }

        else if (compPosition == snakesLaddersArray[17]) //if position equals ladder 3
        {
            compPosition = 96; // set new position
            System.out.println ("Computer Got A Ladder, GO UP!!!");
        }

        else if (compPosition == snakesLaddersArray[18]) //if position equals ladder 3
        {
            compPosition = 94; // set new position
            System.out.println ("Computer Got A Ladder, GO UP!!!");
        }

        else if (compPosition == snakesLaddersArray[19]) //if position equals ladder 3
        {
            compPosition = 92; // set new position
            System.out.println ("Computer Got A Ladder, GO UP!!!");
        }

    if (compPosition < 0 || compPosition > 112) //  ERROR TRAP to catch any unwanted system errors that may occur by chance
    {
        System.out.println ("An error has occured for the computer, please reset the game!!!!!!");
    }
    
    else if (compPosition > 100) // checks if computers's location if greater then a 100
    {
        compPosition = compPosition - compRoll;     // getting old position
        System.out.println ("THE COMPUTER CAN'T JUMP!!! He must land on a 100"); // give message that the computer cant jump
        
    }
    else if (compPosition == 100 && userPosition != 100)
    {
        System.out.println ("THE COMPUTER WON, YOU FAILED!!!"); // print out that the computer won
        
    }
    
    return compPosition; // return the final position to starGame: this position had gone through all checks and test and can be displayed on screen
    }// end getP  




public static int getDice(int diceRoll) {
    diceRoll = (int)(Math.random()*6 )+1 ; 
    return diceRoll; 
}   }