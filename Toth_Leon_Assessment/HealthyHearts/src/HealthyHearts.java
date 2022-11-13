import java.util.Scanner;

public class HealthyHearts {
    public static void main(String[] args) {
        //prompt out to user.
        System.out.print("What is your age?\n" +
                "Please enter age here: " );
        //set up and read input object.
        Scanner input = new Scanner(System.in);
        int age = input.nextInt();

        int maxHeartRate = 220 - age;

        int lowerRange = maxHeartRate / 2;
        float upperRange = (float) (maxHeartRate * 0.85);

        System.out.println("Your maximum heart rate should be " + maxHeartRate + " beats per minute\n" +
                           "Your target HR Zone is " + lowerRange + " - " + (int) upperRange + " beats per minute");
    }
}