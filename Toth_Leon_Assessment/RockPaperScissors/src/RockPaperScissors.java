import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        //start game.
        initializeGame();
    }

    //initialize the game, prompt first question and get firs input.
    public static void initializeGame() {
        //initialize score values.
        int humanScore = 0, computerScore = 0, numberOfRounds = 0;
        //initialize round number input object.
        Scanner firstInput = new Scanner(System.in);

        System.out.print("Enter number of round you want to play: ");

        //gets the input and if not an integer value trows an Exception and quits.
        try {
            numberOfRounds = firstInput.nextInt();
        } catch(Exception e) {
            System.out.println("ERROR... Please next time input an integer between 1-10... Thank you!");
        }

        //checks if the numberOfRounds in range if not trows an error and quits.
        if (numberOfRounds > 0 && numberOfRounds <= 10){
            //the game entrance point
            gameLoop(numberOfRounds, humanScore, computerScore);
        } else {
            System.out.println("ERROR... Please next time input an integer between 1-10... Thank you!");

        }
    }

    //game control loop
    public static void gameLoop(int numberOfRounds, int humanScore, int computerScore){
        //new input object
        Scanner secondInput = new Scanner(System.in);
        //declares the default weapon of choice.
        int selectedItem = 1;

        System.out.println("""
                Please press to select for:\s
                  ROCK: 1\s
                  PAPER: 2\s
                  SCISSORS: 3
                """);
        System.out.print("Input here: ");

        //gets the input and if not an integer value trows an Exception and quits.
        try {
            selectedItem = secondInput.nextInt();
        } catch (Exception e) {
            System.out.println("ERROR... Please enter an integer between 1-3... or 404 to quit.");
            gameLoop(numberOfRounds, humanScore, computerScore);
        }

        //checks if the selectedItem is valid value if not trows an error and quits.
        if (selectedItem == 404) {
            System.out.println("GOOD BY...");
        } else if (selectedItem > 0 && selectedItem <= 3) {
            System.out.println("\n-------------------------------------------------------------------------------- \n");
            //input to the games logic
            evaluateRound(selectedItem, numberOfRounds, humanScore, computerScore);
        } else {
            System.out.println("ERROR... Please enter an integer between 1-3... or 404 to quit.");
            gameLoop(numberOfRounds, humanScore, computerScore);
        }
    }

    public static void evaluateRound(int HumanSelectedItem, int numberOfRounds, int humanScore, int computerScore) {
        //generate the pick of the computer.
        int computerSelectedItem = (int) (Math.random() * 3) + 1;
        //makes an array out of the player picked input and the computer generated pick.
        int[] selectedItemArray = {HumanSelectedItem, computerSelectedItem};
        //converts the player picked input and the computer generated pick in string values from integer.
        String[] stringSelectedItem = convertIntItemsToString(selectedItemArray);
        //updates the remaining number of rounds.
        numberOfRounds--;

        //stores the outcome of the round.
        int winnerStatus = 4;
        //compares the inputs, and decides the winner and updates scores.
        if (computerSelectedItem == HumanSelectedItem) {
            humanScore += 1;
            computerScore += 1;
            winnerStatus = 0;
        } else if ((computerSelectedItem == 1 && HumanSelectedItem == 2)
                || (computerSelectedItem == 2 && HumanSelectedItem == 3)
                || (computerSelectedItem == 3 && HumanSelectedItem == 1)) {
            humanScore += 1;
            winnerStatus = 1;
        } else if ((computerSelectedItem == 1 && HumanSelectedItem == 3)
                || (computerSelectedItem == 2 && HumanSelectedItem == 1)
                || (computerSelectedItem == 3 && HumanSelectedItem == 2)) {
            computerScore += 1;
            winnerStatus = 2;
        }

        //checks if tha number of round played out.
        if (numberOfRounds < 1) {
            //print scoreboard.
            printScoreboard(stringSelectedItem, numberOfRounds, humanScore, computerScore);
            //print round outcome.
            printRoundWinner(winnerStatus);
            //if there is no more rounds calls the end game method.
            endGameScreen(humanScore, computerScore);
        } else {
            //print scoreboard.
            printScoreboard(stringSelectedItem, numberOfRounds, humanScore, computerScore);
            //print round outcome.
            printRoundWinner(winnerStatus);
            //restarts the cycle until the number of rounds run out.
            gameLoop(numberOfRounds, humanScore, computerScore);
        }
    }

    //prints out the winner in actual round.
    public static void printRoundWinner(int winnerStatus) {
        String[] winnerMessageArray = {"This round is a tie. \n",
                "The computer lost, You WON this round! \n",
                "The computer WON, You lost this round... \n"};

        System.out.println(winnerMessageArray[winnerStatus] +
                "\n--------------------------------------------------------------------------------\n");
    }

    //print out scoreboard and selected items.
    public static void printScoreboard(String[] stringSelectedItem, int numberOfRounds, int humanScore, int computerScore) {
        System.out.println("SCOREBOARD, NUMBER OF POINTS " +
                " | YOU - " + humanScore +
                " | COMPUTER - " + computerScore +
                " | ROUNDS LEFT: " + numberOfRounds);
        //prints out in string format the picks of the player and the computer.
        System.out.println("You selected: " + stringSelectedItem[0] + " the computer selected: " + stringSelectedItem[1] + "\n");
    }

    //converts int type items to string.
    public static String[] convertIntItemsToString(int[] array) {
        String[] outputArray = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                outputArray[i] = "ROCK";
            } else if (array[i] == 2) {
                outputArray[i] = "PAPER";
            } else if (array[i] == 3){
                outputArray[i] = "SCISSORS";
            }
        }
        return outputArray;
    }

    //computes the winner and prompt the winner and prompt the end screen
    public static void endGameScreen(int humanScore, int computerScore){
        if (humanScore == computerScore){
            System.out.println("It's a Tie. \n");
        } else if (humanScore > computerScore) {
            System.out.println("The winner is YOU !!! \n");
        } else {
            System.out.println("The winner is the COMPUTER ... \n");
        }
        anotherGame();
    }

    //print out if the player want to play another game and takes an input.
    public static void anotherGame() {
        System.out.println("Want to play again?");
        System.out.print("Type YES or NO: ");

        //initialize input
        Scanner thirdInput = new Scanner(System.in);
        String playAgain = thirdInput.nextLine();

        //checks if the input match to continue value, if not exits the game.
        String yes = "yes";
        if (yes.equals(playAgain.toLowerCase())) {
            initializeGame();
        } else {
            System.out.println("\nThanks for playing!");
        }
    }
}