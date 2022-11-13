import java.util.Scanner;

public class DogGenetics {
    public static void main(String[] args) {
        System.out.print("What is your dog's name? \nEnter here: ");
        //initialize input object.
        Scanner input = new Scanner(System.in);
        //get input dog name.
        String dogName = input.nextLine();

        System.out.println("\nWell then, I have this highly reliable report on " +
                            dogName +
                            "'s prestigious background right here.\n" +
                            "\n" +
                            dogName + " is:");

        dnaCalculator();
    }

    public static void dnaCalculator(){
        int procentage;
        //initial percentage range.
        int range = 100;
        int[] output = new int[4];
        //calculate percentages.
        for (int i = 0; i < 4; i++){
            //generate random number in range.
            procentage = (int)(Math.random() * range) + 1;
            //puts percentage in output array.
            output[i] = procentage;
            //updates range for next percentage to be generated
            range -= procentage;
        }

        System.out.println("\n" +
                           output[0] + "% St. Bernard\n" +
                           output[1] + "% Chihuahua\n" +
                           output[2] + "% Dramatic RedNosed Asian Pug\n" +
                           output[3] + "% Common Cur\n" +
                           range + "% King Doberman\n\n" +
                           "Wow, that's QUITE the dog! ");
    }
}